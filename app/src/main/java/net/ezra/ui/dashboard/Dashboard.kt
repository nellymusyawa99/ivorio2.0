package net.ezra.ui.dashboard



import android.annotation.SuppressLint
import android.app.ProgressDialog
import android.content.Intent
import android.net.Uri
import android.widget.Toast
import androidx.activity.compose.BackHandler
import androidx.activity.compose.ManagedActivityResultLauncher
import androidx.activity.compose.rememberLauncherForActivityResult
import androidx.activity.result.ActivityResult
import androidx.activity.result.contract.ActivityResultContracts
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountCircle
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.MailOutline
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.filled.Refresh
import androidx.compose.material.icons.filled.Settings
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import com.google.firebase.Firebase
import com.google.firebase.auth.EmailAuthProvider
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.FirebaseUser
import com.google.firebase.firestore.FirebaseFirestore
import com.google.firebase.firestore.ktx.toObject
import net.ezra.navigation.ROUTE_LOGIN

import com.google.firebase.firestore.SetOptions
import com.google.firebase.firestore.firestore
import net.ezra.R
import net.ezra.navigation.ROUTE_ADD_STUDENTS
import net.ezra.navigation.ROUTE_DASHBOARD
import net.ezra.navigation.ROUTE_HOME


private var progressDialog: ProgressDialog? = null
@OptIn(ExperimentalMaterial3Api::class)
@SuppressLint("UnusedMaterialScaffoldPaddingParameter")
@Composable
fun DashboardScreen(navController: NavHostController)  {
    var school by remember { mutableStateOf("") }
    var name by remember { mutableStateOf("") }
    val currentUser = FirebaseAuth.getInstance().currentUser
    val firestore = FirebaseFirestore.getInstance()
  //  var user: User? by remember { mutableStateOf(null) }
    var isLoading by remember { mutableStateOf(true) }
    var studentCount by remember { mutableIntStateOf(0) }
    var currentPassword by remember { mutableStateOf("") }
    var newPassword by remember { mutableStateOf("") }
    var confirmPassword by remember { mutableStateOf("") }

    var loading by remember { mutableStateOf(false) }

    val firestores = Firebase.firestore


    val context = LocalContext.current
    val callLauncher: ManagedActivityResultLauncher<Intent, ActivityResult> =
        rememberLauncherForActivityResult(contract = ActivityResultContracts.StartActivityForResult()) { _ ->
        }


    BackHandler {
        navController.popBackStack()

    }


    // Fetch user details from Firestore
    LaunchedEffect(key1 = currentUser?.uid) {
        if (currentUser != null) {
            val userDocRef = firestore.collection("users").document(currentUser.uid)
            userDocRef.get()
                .addOnSuccessListener { document ->
                    if (document.exists()) {
        //                user = document.toObject<User>()
                    }
                    isLoading = false
                }
                .addOnFailureListener { e ->
                    // Handle failure
                    isLoading = false
                }
        }
    }

    LaunchedEffect(Unit) {
        firestores.collection("Students")
            .get()
            .addOnSuccessListener { result ->
                studentCount = result.size()
            }
            .addOnFailureListener { exception ->
                // Handle failures
            }
    }

    Scaffold(
        topBar = {
            CenterAlignedTopAppBar(
                title = {
                    Text(text = " My Profile", color = Color.White, fontSize = 30.sp)
                },
                colors = TopAppBarDefaults.topAppBarColors(
                    containerColor = Color(0xffA865B5),
                    titleContentColor = Color.White,
                ),
                navigationIcon = {
                    IconButton(onClick = {navController.navigate(ROUTE_HOME)}) {
                        Icon(Icons.Filled.ArrowBack, "backIcon",tint = Color.White)
                    }
                },



            )
        }, content = {
LazyColumn {
    item {
        Card (
            modifier = Modifier
                .size(500.dp)
                .padding(8.dp),
            shape = RoundedCornerShape(15.dp),
            elevation = 8.dp
        ){
            Column(
                modifier = Modifier
                    .padding(10.dp)
                    .fillMaxWidth()
                    .wrapContentHeight(),
                verticalArrangement = Arrangement.Center,
                horizontalAlignment = Alignment.CenterHorizontally
            ){
                Text(
                    text = "Welcome User",
                    textAlign = TextAlign.Center,
                    fontWeight = FontWeight.ExtraBold,
                    fontFamily = FontFamily.Cursive,
                    fontSize = 50.sp

                )

                Text(
                       text = "Order More and Get AMAZING OFFERS NOW!!!! ",
                       fontFamily = FontFamily.Cursive,
                       fontWeight = FontWeight.Bold,
                       color = Color.Black,
                       fontSize = 30.sp
                   )


                    Text(
                        text = stringResource(id = R.string.call),
                        fontSize = 30.sp,
                        modifier = Modifier
                            .padding(16.dp)
                            .clickable {
                                val intent = Intent(Intent.ACTION_DIAL)
                                intent.data = Uri.parse("tel:+254722281016")
                                callLauncher.launch(intent)
                            }
                    )

                Text(text = "Payments made through :",
                    fontWeight = FontWeight.Bold,
                    fontSize = 30.sp)

                Image(painter = painterResource(id = net.ezra.R.drawable.money),
                                   contentDescription = null, )



                Text(text = "Our Location: Nkubu Town in Meru county, Building name: Central Plaza",
                    fontSize = 20.sp,
                    fontWeight = FontWeight.Bold)




            }

        }


    }
}
        }
    )
}





//                            Dashboard starts here

                         //   val dashboardItems = listOf(
                             //   DashboardItemData(
                               //     title = "Profile",
                              //     icon = Icons.Default.AccountCircle,
                              //     badgeCount = 0,
                               //    onClick = {
                                        // Navigate to profile screen
                               //     }
                              //  ),
                              //  DashboardItemData(
                               //     title = "Settings",
                                 //   icon = Icons.Default.Settings,
                                //    badgeCount = 3,
                                 //   onClick = {
                                        // Navigate to settings screen
                                  //  }
                             //   ),
                               // DashboardItemData(
                                  //  title = "Students",
                                  //  icon = Icons.Default.Person,
                                  //  badgeCount = 4,
                                 //   onClick = {
                                        // Navigate to messages screen
                                //    }
                              //  ),
                                // Add more dashboard items as needed
                           // )



                         //   LazyVerticalGrid(
                         //       columns = GridCells.Fixed(2),
                          //      modifier = Modifier.padding(16.dp)
                        //    ) {
                         //       items(dashboardItems) { item ->
                         //           DashboardItem(item)
                         //       }
                         //   }






//                            Dashboard ends here













//@OptIn(ExperimentalMaterialApi::class)
//@Composable
//fun DashboardItem(item: DashboardItemData) {
//    Card(
 //       modifier = Modifier
 //           .fillMaxWidth()
//            .padding(8.dp),
 //       shape = RoundedCornerShape(8.dp),
  //      elevation = 8.dp,
//        backgroundColor = Color.White,
 //       onClick = item.onClick
 //   ) {
  //      Row(
  //          modifier = Modifier
 //               .padding(16.dp)
  //              .fillMaxWidth(),
 //           verticalAlignment = Alignment.CenterVertically
  //      ) {
  //          Icon(
//                imageVector = item.icon,
 //               contentDescription = "Dashboard Icon",
  //              tint = Color.Black,
//                modifier = Modifier.size(36.dp)
//            )
 //           Spacer(modifier = Modifier.width(16.dp))
  //          Text(
 //               text = item.title,
 //               style = MaterialTheme.typography.subtitle1,
 //               color = Color.Black
 //           )
            // Add a badge if the badge count is greater than 0
 //           if (item.badgeCount > 0) {
  //              Badge(count = item.badgeCount)
 //           }
  //      }
 //   }
//}
//@Composable
//fun Badge(count: Int) {
 //   Box(
   //     modifier = Modifier
  //          .padding(start = 8.dp)
  //          .size(20.dp)
 //           .clip(CircleShape)
  //          .background(Color.Red),
  //      contentAlignment = Alignment.Center
 //   ) {
 //       Text(
  //          text = count.toString(),
   //         style = MaterialTheme.typography.caption,
   //         color = Color.White
  //      )
  //  }
//}
//data class DashboardItemData(
  //  val title: String,
  //  val icon: ImageVector,
  //  val badgeCount: Int,
 //   val onClick: () -> Unit
//)
//data class User(
 //   val userId: String = "",
 //   val school: String = "",
 //   val name: String = ""
//)

//fun saveUserDetails(user: User, param: (Any) -> Unit) {
   // val firestore = FirebaseFirestore.getInstance()
   // firestore.collection("users").document(user.userId)
   //     .set(user, SetOptions.merge())
  //      .addOnSuccessListener {

  //          progressDialog?.dismiss()
            // Success message or navigation
  //      }
   //     .addOnFailureListener {

  //          progressDialog?.dismiss()
            // Handle failure
   //     }
//}
