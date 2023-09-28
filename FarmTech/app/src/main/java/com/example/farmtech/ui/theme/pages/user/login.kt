package com.example.farmtech.ui.theme.pages.user

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.example.farmtech.R
import com.example.farmtech.data.AuthRepository
import com.example.farmtech.navigation.ROUTE_LOGIN
import com.example.farmtech.navigation.ROUTE_SIGN_UP
import com.example.farmtech.ui.theme.FarmTechTheme

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun LoginScreen(navController: NavHostController) {
    Column(modifier = Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center

    ) {
        Image(painter = painterResource(id = R.drawable.organic), contentDescription = null, modifier = Modifier.size(130.dp), contentScale = ContentScale.Fit )

        var context = LocalContext.current
        Text(text = "Login Here")

        var email by remember { mutableStateOf(TextFieldValue("")) }
        var password by remember { mutableStateOf(TextFieldValue("")) }

        Spacer(modifier = Modifier.height(20.dp))
        OutlinedTextField(value = email, onValueChange = { email = it },
            label = { Text(text = "*email*") },
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Text)
        )
        Spacer(modifier = Modifier.height(20.dp))
        OutlinedTextField(value = password, onValueChange = { password = it },
            label = { Text(text = "*password*") },
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Password)
        )
        Spacer(modifier = Modifier.height(20.dp))
        Button(onClick ={var authRepository = AuthRepository(navController, context)

            authRepository.login(email.text.trim(),password.text.trim())}


        ) {
            Text(text = "SignUp")

        }
        Spacer(modifier = Modifier.height(20.dp))

        Button(onClick = {navController.navigate(ROUTE_SIGN_UP) }) {
            Text(text = "Don't have an account? Sign Up")
        }

    }



}
@Preview
@Composable
fun LoginPreview() {
    FarmTechTheme {
        LoginScreen(rememberNavController())
    }

}