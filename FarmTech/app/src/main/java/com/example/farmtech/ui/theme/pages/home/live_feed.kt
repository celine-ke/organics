package com.example.farmtech.ui.theme.pages.home

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.example.farmtech.R
import com.example.farmtech.models.User
import com.example.farmtech.navigation.ROUTE_LOGIN
import com.example.farmtech.navigation.ROUTE_SHOP
import com.example.farmtech.navigation.ROUTE_SIGN_UP
import com.example.farmtech.navigation.ROUTE_UPDATE
import com.example.farmtech.ui.theme.FarmTechTheme

@Composable
fun LiveFeedScreen(navController: NavHostController) {
    Column(modifier = Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center

    ) {

    Image(painter = painterResource(id = R.drawable.organic), contentDescription = null, modifier = Modifier.size(130.dp), contentScale = ContentScale.Fit )
    
        
    Button(onClick = {navController.navigate(ROUTE_SHOP)}) {
        Text(
            text = "SHOP",
            color = Color.Green,
            fontWeight = FontWeight.Bold



        )
    }
        Button(onClick = {navController.navigate(ROUTE_LOGIN)}) {
            Text(text = "LOGIN",color = Color.Green,
                fontWeight = FontWeight.Bold)
        }

        Button(onClick = {navController.navigate(ROUTE_UPDATE)}) {
            Text(text = "UPDATE",color = Color.Green,
                fontWeight = FontWeight.Bold)
        }
        Button(onClick = {navController.navigate(ROUTE_SIGN_UP)}) {
            Text(text = "SIGN UP",color = Color.Green,
                fontWeight = FontWeight.Bold)
        }

    }
}

@Preview
@Composable
fun LiveFeedPreview() {
    FarmTechTheme {
        LiveFeedScreen(rememberNavController())
    }

}
