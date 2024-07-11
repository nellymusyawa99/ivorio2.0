package net.ezra.ui.home






import android.annotation.SuppressLint
import android.content.ClipData.Item
import android.content.Intent
import android.net.Uri
import androidx.activity.compose.ManagedActivityResultLauncher
import androidx.activity.compose.rememberLauncherForActivityResult
import androidx.activity.result.ActivityResult
import androidx.activity.result.contract.ActivityResultContracts
import androidx.compose.animation.core.Animatable
import androidx.compose.animation.core.tween
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.gestures.scrollable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.pager.PagerState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
//noinspection UsingMaterialAndMaterial3Libraries
import androidx.compose.material.BottomNavigation
//noinspection UsingMaterialAndMaterial3Libraries
import androidx.compose.material.BottomNavigationItem
import androidx.compose.material.ScrollableTabRow
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountCircle
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material.icons.filled.Person
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.CardElevation
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import coil.size.Size
import net.ezra.R
import net.ezra.navigation.ROUTE_ABOUT
import net.ezra.navigation.ROUTE_ADD_PRODUCT
import net.ezra.navigation.ROUTE_ADD_PRODUCTS
import net.ezra.navigation.ROUTE_ADD_STUDENTS
import net.ezra.navigation.ROUTE_DASHBOARD
import net.ezra.navigation.ROUTE_HOME
import net.ezra.navigation.ROUTE_LOGIN
import net.ezra.navigation.ROUTE_SEARCH
import net.ezra.navigation.ROUTE_VIEW_PROD
import net.ezra.navigation.ROUTE_VIEW_STUDENTS


data class Screen(val title: String, val icon: Int)
@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter", "ResourceAsColor")
@OptIn(ExperimentalMaterial3Api::class, ExperimentalFoundationApi::class)
@Composable
fun HomeScreen(navController: NavHostController) {

    var isDrawerOpen by remember { mutableStateOf(false) }

  //  val callLauncher: ManagedActivityResultLauncher<Intent, ActivityResult> =
   //     rememberLauncherForActivityResult(contract = ActivityResultContracts.StartActivityForResult()) { _ ->

   //     }

    Scaffold(
       // topBar = {
       //     CenterAlignedTopAppBar(
       //         title = {
       //             Text(text = "Ivorio Lab Supplies")
      //          },
//                navigationIcon = @Composable {
//                    if (!isDrawerOpen) {
//                        IconButton(onClick = { isDrawerOpen = true }) {
//                            Icon(
//                                Icons.Default.Menu,
//                                contentDescription = "Menu",
//                                tint = Color.Black
//                                )
//                        }
//                    }
//                },

//                actions = {
//                    IconButton(onClick = {
//                        navController.navigate(ROUTE_LOGIN) {
//                            popUpTo(ROUTE_HOME) { inclusive = true }
//                        }
//
//                    }) {
//                        Icon(
//                            imageVector = Icons.Filled.AccountCircle,
//                            contentDescription = null,
//                            tint = Color.Black
//                        )
//                    }
//                },

          //      colors = TopAppBarDefaults.topAppBarColors(
       //             containerColor = Color(0xffA865B5),
      //              titleContentColor = Color.White,

  //              )

 //           )
 //       },

        content = @Composable {
            Box(
                modifier = Modifier
                    .fillMaxSize()
                    .clickable {
                        if (isDrawerOpen) {
                            isDrawerOpen = false
                        }
                    }
            ) {


                LazyColumn (
                    modifier = Modifier
                        .background(Color(0xffFFFFFF)),
                ) {
                    item {
                        Spacer(modifier = Modifier.height(20.dp))
                        Row {
                            LazyRow {
                                item {
                                    Spacer(modifier = Modifier.width(10.dp))
                                    Text(
                                        text = "Glucostixs",
                                        fontWeight = FontWeight.Bold,
                                        fontSize = 15.sp,
                                        modifier = Modifier.clickable {
                                            navController.navigate(ROUTE_VIEW_PROD)
                                        }
                                    )


                                    Spacer(modifier = Modifier.width(20.dp))

                                    Text(text = "Gloves",
                                        fontWeight = FontWeight.Bold,
                                        fontSize = 15.sp,
                                        modifier = Modifier.clickable {
                                            navController.navigate(ROUTE_VIEW_PROD)
                                        }
                                    )

                                    Spacer(modifier = Modifier.width(20.dp))

                                    Text(text = "Malaria kit",
                                        fontWeight = FontWeight.Bold,
                                        fontSize = 15.sp,
                                        modifier = Modifier.clickable {
                                            navController.navigate(ROUTE_VIEW_PROD)
                                        }
                                    )

                                    Spacer(modifier = Modifier.width(20.dp))

                                    Text(text = "Pregnancy strips",
                                        fontWeight = FontWeight.Bold,
                                        fontSize = 15.sp,
                                        modifier = Modifier.clickable {
                                            navController.navigate(ROUTE_VIEW_PROD)
                                        }
                                    )

                                    Spacer(modifier = Modifier.width(20.dp))

                                    Text(text = "Glucometer",
                                        fontWeight = FontWeight.Bold,
                                        fontSize = 15.sp,
                                        modifier = Modifier.clickable {
                                            navController.navigate(ROUTE_VIEW_PROD)
                                        }
                                    )
                                }
                            }
                        }

                        Spacer(modifier = Modifier.height(30.dp))

                        LazyRow {
                            item {

                                Card(
                                    shape = RoundedCornerShape(20.dp)
                                ) {
                                    Box {
                                        Image(
                                            painter = painterResource(id = R.drawable.card1),
                                            contentDescription = null
                                        )
                                    }
                                }

                                Spacer(modifier = Modifier.width(10.dp))

                                Card(
                                    shape = RoundedCornerShape(20.dp),

                                ) {
                                    Box {
                                        Image(
                                            painter = painterResource(id = R.drawable.card2),
                                            contentDescription = null
                                        )
                                    }
                                }

                            }
                        }

                        Spacer(modifier = Modifier.height(10.dp))

                        Row {
                            Text(
                                text = "Categories",
                                fontWeight = FontWeight.Bold,
                                color = Color(0xffA865B5),
                                fontSize = 30.sp
                            )
                        }

                        Spacer(modifier = Modifier.height(10.dp))

                        Row {
                            Text(
                                text = "Consumable Reagents",
                                fontSize = 20.sp,
                                fontWeight = FontWeight.Bold
                            )
                        }


                            Spacer(modifier = Modifier.height(15.dp))

                        Row {

                            Card(
                                modifier = Modifier
                                    .size(150.dp),
                                RoundedCornerShape(15.dp),


                            ) {
                                Box{
                                    Image(
                                        painter = painterResource(id = R.drawable.gloves),
                                        contentDescription = null,
                                        modifier = Modifier
                                            .size(200.dp)
                                    )

                                    Box(
                                        modifier = Modifier
                                            .fillMaxSize(),
                                        contentAlignment = Alignment.TopCenter

                                    ) {

                                        androidx.compose.material.Text(
                                            text = "Surgical gloves",
                                            fontWeight = FontWeight.Bold
                                        )

                                    }

                                }
                            }

                            Spacer(modifier = Modifier.width(30.dp))

                            Card(
                                modifier = Modifier
                                    .size(150.dp),
                                RoundedCornerShape(15.dp)

                            ) {
                                Box {
                                    Image(
                                        painter = painterResource(id = R.drawable.needle1),
                                        contentDescription = null,
                                        modifier = Modifier
                                            .size(300.dp)
                                    )

                                    Box(
                                        modifier = Modifier
                                            .fillMaxSize(),
                                        contentAlignment = Alignment.TopCenter

                                    ) {

                                        androidx.compose.material.Text(
                                            text = "Needle G21",
                                            fontWeight = FontWeight.Bold
                                        )

                                    }

                                }
                            }


                        }

                        Spacer(modifier = Modifier.height(10.dp))

                        Row {
                            Card(
                                modifier = Modifier
                                    .size(150.dp),
                                RoundedCornerShape(15.dp)

                            ) {
                                Box {
                                    Image(
                                        painter = painterResource(id = R.drawable.gloves2),
                                        contentDescription = null,
                                        modifier = Modifier
                                            .size(300.dp)
                                    )

                                    Box(
                                        modifier = Modifier
                                            .fillMaxSize(),
                                        contentAlignment = Alignment.TopCenter

                                    ) {

                                        androidx.compose.material.Text(
                                            text = "Paper gloves",
                                            fontWeight = FontWeight.Bold
                                        )

                                    }

                                }
                            }

                            Spacer(modifier = Modifier.width(30.dp))

                            Card(
                                modifier = Modifier
                                    .size(150.dp),
                                RoundedCornerShape(15.dp)

                            ) {
                                Box {
                                    Image(
                                        painter = painterResource(id = R.drawable.needle2),
                                        contentDescription = null,
                                        modifier = Modifier
                                            .size(200.dp)
                                    )

                                    Box(
                                        modifier = Modifier
                                            .fillMaxSize(),
                                        contentAlignment = Alignment.TopCenter

                                    ) {

                                        androidx.compose.material.Text(
                                            text = "Needle G22",
                                            fontWeight = FontWeight.Bold
                                        )

                                    }


                                }
                            }

                        }

                        Spacer(modifier = Modifier.height(15.dp))

                        Row {
                            Text(text = " Click for More",
                                fontWeight = FontWeight.Bold,
                                color = Color.Red,
                                modifier = Modifier
                                    .clickable { navController.navigate(ROUTE_ADD_PRODUCT) }
                            )
                        }


                        Spacer(modifier = Modifier.height(15.dp))


                        Row {
                            Text(
                                text = "Reagents",
                                fontSize = 20.sp,
                                fontWeight = FontWeight.Bold
                            )
                        }


                        Spacer(modifier = Modifier.height(15.dp))

                        Row {

                            Card(
                                modifier = Modifier
                                    .size(150.dp),
                                RoundedCornerShape(15.dp)

                            ) {
                                Box{
                                    Image(
                                        painter = painterResource(id = R.drawable.glucometer),
                                        contentDescription = null,
                                        modifier = Modifier
                                            .size(200.dp)
                                    )

                                    Box(
                                        modifier = Modifier
                                            .fillMaxSize(),
                                        contentAlignment = Alignment.TopCenter

                                    ) {

                                        androidx.compose.material.Text(
                                            text = "Glucometer",
                                            fontWeight = FontWeight.Bold
                                        )

                                    }

                                }
                            }

                            Spacer(modifier = Modifier.width(30.dp))

                            Card(
                                modifier = Modifier
                                    .size(150.dp),
                                RoundedCornerShape(15.dp)

                            ) {
                                Box {
                                    Image(
                                        painter = painterResource(id = R.drawable.glucostixs),
                                        contentDescription = null,
                                        modifier = Modifier
                                            .size(300.dp)
                                    )

                                    Box(
                                        modifier = Modifier
                                            .fillMaxSize(),
                                        contentAlignment = Alignment.TopCenter

                                    ) {

                                        androidx.compose.material.Text(
                                            text = "Glucostixs",
                                            fontWeight = FontWeight.Bold
                                        )

                                    }

                                }
                            }


                        }

                        Spacer(modifier = Modifier.height(10.dp))

                        Row {
                            Card(
                                modifier = Modifier
                                    .size(150.dp),
                                RoundedCornerShape(15.dp)

                            ) {
                                Box {
                                    Image(
                                        painter = painterResource(id = R.drawable.salmonella),
                                        contentDescription = null,
                                        modifier = Modifier
                                            .size(300.dp)
                                    )

                                    Box(
                                        modifier = Modifier
                                            .fillMaxSize(),
                                        contentAlignment = Alignment.TopCenter

                                    ) {

                                        androidx.compose.material.Text(
                                            text = "Salmonella Antigen",
                                            fontWeight = FontWeight.Bold
                                        )

                                    }

                                }
                            }

                            Spacer(modifier = Modifier.width(30.dp))

                            Card(
                                modifier = Modifier
                                    .size(150.dp),
                                RoundedCornerShape(15.dp)

                            ) {
                                Box {
                                    Image(
                                        painter = painterResource(id = R.drawable.malaria),
                                        contentDescription = null,
                                        modifier = Modifier
                                            .size(200.dp),


                                    )

                                    Box(
                                        modifier = Modifier
                                            .fillMaxSize(),
                                        contentAlignment = Alignment.TopCenter

                                    ) {

                                        androidx.compose.material.Text(
                                            text = "Malaria kit",
                                            fontWeight = FontWeight.Bold
                                        )

                                    }


                                }
                            }

                        }

                        Spacer(modifier = Modifier.height(15.dp))

                        Row {
                            Text(text = "Click for More",
                                fontWeight = FontWeight.Bold,
                                color = Color.Red,
                                modifier = Modifier
                                    .clickable { navController.navigate(ROUTE_ADD_PRODUCT) }
                            )
                        }
                        
                        Spacer(modifier = Modifier.height(70.dp))





























                            val currentPage = remember { mutableStateOf(0) }

                       // LazyRow {
                        //    item {
                         //       Box {
                         //           Card(
                          //              modifier = Modifier.padding(5.dp)
                          //          ) {
                         //               Image(
                         //                   painter = painterResource(id = R.drawable.equipment4),
                         //                   contentDescription = "null",
                        //                    modifier = Modifier
                        //                        .width(300.dp)
                      //                          .height(300.dp)
                    //                    )
                   //                 }
                  //              }
                  //          }
                 //           item {
                 //               Box{
                 //               Card(
                 //                   modifier = Modifier.padding(5.dp)
                 //               ) {
                 //                   Image(
                  //                      painter = painterResource(id = R.drawable.equipment2),
                  //                      contentDescription = "null",
                  //                      modifier = Modifier
                  //                          .width(300.dp)
                 //                           .height(300.dp)
                 //                   )
             //                   }
               //             }
                //            }
                //            item {
               //                 Box {
              //                  Card(
             //                       modifier = Modifier.padding(5.dp)
              //                  ) {
             //                       Image(
            //                            painter = painterResource(id = R.drawable.equipment3),
          //                              contentDescription = "null",
         //                               modifier = Modifier
        //                                    .width(300.dp)
        //                                    .height(300.dp)
       //                             )
       //                         }
       //                     }
      //                      }
     //                   }




                     //   Text(
                   //     text = stringResource(id = R.string.call),
                   //     fontSize = 20.sp,
                  //      modifier = Modifier
                   //         .padding(16.dp)
                  //          .clickable {

                    //            val intent = Intent(Intent.ACTION_DIAL)
                   //             intent.data = Uri.parse("tel:+254796759850")

                  //              callLauncher.launch(intent)
                 //           }
                //    )

                   // Text(
                    //    text = stringResource(id = R.string.developer),
                    //    fontSize = 20.sp,
                   // )

                   // Spacer(modifier = Modifier.height(15.dp))

                //    Text(
            //            modifier = Modifier
              //              .clickable {
            //                    navController.navigate(ROUTE_LOGIN) {
            //                        popUpTo(ROUTE_HOME) { inclusive = true }
         //                       }
         //                   },
        //                text = "Login Here",
       //                 textAlign = TextAlign.Center,
     //                   fontSize = 20.sp,
     //                   color = MaterialTheme.colorScheme.onSurface
    //                )



      //              Text(
      //                  modifier = Modifier

         //                   .clickable {
   //                             navController.navigate(ROUTE_ADD_PRODUCT) {
  //                                  popUpTo(ROUTE_HOME) { inclusive = true }
  //                              }
  //                          },
   //                     text = "Add Products",
    //                    textAlign = TextAlign.Center,
   //                     fontSize = 20.sp,
   //                     color = MaterialTheme.colorScheme.onSurface
   //                 )

    //                Text(
    //                    modifier = Modifier

        //                    .clickable {
       //                         navController.navigate(ROUTE_ADD_STUDENTS) {
    //                                popUpTo(ROUTE_HOME) { inclusive = true }
    //                            }
    //                        },
     //                   text = "Add Students",
     //                   textAlign = TextAlign.Center,
    //                    fontSize = 20.sp,
    //                    color = MaterialTheme.colorScheme.onSurface
    //                )

  //                  Text(
  //                      modifier = Modifier

//                            .clickable {
  //                              navController.navigate(ROUTE_VIEW_PROD) {
  //                                  popUpTo(ROUTE_HOME) { inclusive = true }
   //                             }
   //                         },
   //                     text = "view Products",
   //                     textAlign = TextAlign.Center,
    //                    fontSize = 20.sp,
     //                   color = MaterialTheme.colorScheme.onSurface
      //              )


                }
                }

            }

        },

        bottomBar = { BottomBar(navController = navController) }







    )

    AnimatedDrawer(
        isOpen = isDrawerOpen,
        onClose = { isDrawerOpen = false }
    )
}

@Composable
fun AnimatedDrawer(isOpen: Boolean, onClose: () -> Unit) {
    val drawerWidth = remember { Animatable(if (isOpen) 250f else 0f) }

    LaunchedEffect(isOpen) {
        drawerWidth.animateTo(if (isOpen) 250f else 0f, animationSpec = tween(durationMillis = 300))
    }

    Surface(
        modifier = Modifier
            .fillMaxHeight()
            .width(drawerWidth.value.dp)
            ,
        color = Color.LightGray,
//        elevation = 16.dp
    ) {
        Column {
            Text(
                text = "Drawer Item 1"

            )
            Text(
                text = "Drawer Item 2"
            )
            Text(
                text = "Drawer Item 3",
                modifier = Modifier.clickable {  }
            )
            Spacer(modifier = Modifier.height(16.dp))
            Text(text = stringResource(id = R.string.developer))

        }
    }
}






@Composable
fun BottomBar(navController: NavHostController) {
    val selectedIndex = remember { mutableStateOf(0) }
    BottomNavigation(
        elevation = 10.dp,
        backgroundColor = Color(0xffA865B5)


    ) {

        BottomNavigationItem(icon = {
            Image(painter = painterResource(id = R.drawable.home2),
                contentDescription = "null",
                modifier = Modifier
                    .width(30.dp)
                    .height(30.dp))
        },
            label = { Text(text = "Home",
                color =  Color.White) },
            selected = (selectedIndex.value == 0),
            onClick = {
                navController.navigate(ROUTE_HOME) {
                    popUpTo(ROUTE_HOME) { inclusive = true }
                }
            })

        BottomNavigationItem(icon = {
            Image(painter = painterResource(id = R.drawable.plus),
                contentDescription = "null",
                modifier = Modifier
                    .width(30.dp)
                    .height(30.dp))
        },
            label = { Text(text = "Add",
                color =  Color.White) },
            selected = (selectedIndex.value == 0),
            onClick = {
                navController.navigate(ROUTE_ADD_PRODUCTS) {
                    popUpTo(ROUTE_HOME) { inclusive = true }
                }
            })

//       BottomNavigationItem(icon = {
//            Image(painter = painterResource(id = R.drawable.cart),
//                contentDescription = "null",
//                modifier = Modifier
//                    .width(30.dp)
//                    .height(30.dp))
//        },
//            label = { Text(text = "Cart",
//                color =  Color.White) },
//            selected = (selectedIndex.value == 1),
//            onClick = {
//                navController.navigate(ROUTE_SEARCH) {
//                    popUpTo(ROUTE_HOME) { inclusive = true }
//                }
//           })

        BottomNavigationItem(icon = {
            Image(painter = painterResource(id = R.drawable.profile),
                contentDescription = "null",
                modifier = Modifier
                    .width(30.dp)
                    .height(30.dp))
        },
            label = { Text(
                text = "Profile",
                color =  Color.White) },
            selected = (selectedIndex.value == 2),
            onClick = {

                navController.navigate(ROUTE_LOGIN) {
                    popUpTo(ROUTE_HOME) { inclusive = true }
                }

            })

    }
}