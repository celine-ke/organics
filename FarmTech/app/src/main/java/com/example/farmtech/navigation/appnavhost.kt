package com.example.farmtech.navigation

import UpdateProductsScreen
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.farmtech.ui.theme.pages.home.LiveFeedScreen
import com.example.farmtech.ui.theme.pages.product.AddProductsScreen
import com.example.farmtech.ui.theme.pages.product.ShopScreen
import com.example.farmtech.ui.theme.pages.user.LoginScreen
import com.example.farmtech.ui.theme.pages.user.SignUpScreen

@Composable
fun AppNavHost(
    navController:NavHostController = rememberNavController(),
    modifier: Modifier = Modifier,
    startDestination:String =ROUTE_HOME ) {
    NavHost(
        navController = rememberNavController(),
        startDestination = startDestination
       )
    {
        composable(ROUTE_HOME){
            LiveFeedScreen(navController)
        }
        composable(ROUTE_SIGN_UP){
            SignUpScreen(navController)
        }
        composable(ROUTE_ADD_PROD){
            AddProductsScreen(navController)
        }
        composable(ROUTE_SHOP){
            ShopScreen(navController)
        }
        composable(ROUTE_LOGIN){
            LoginScreen(navController)
        }
        composable(ROUTE_UPDATE){
            UpdateProductsScreen(navController)
        }
    }}

