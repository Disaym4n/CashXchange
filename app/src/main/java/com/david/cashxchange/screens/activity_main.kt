package com.david.cashxchange.screens

import androidx.compose.foundation.layout.Column
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.ui.Alignment
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp


@Composable
fun CashXchange() {
    Column(modifier = Modifier
        .fillMaxSize()
        .padding(top = 70.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {

        Text(
            text = "Cash xchange",
            modifier = Modifier
                .padding(top = 50.dp, end = 30.dp, start = 35.dp)
                .align(Alignment.CenterHorizontally),
            style = TextStyle(fontSize = 36.sp, fontWeight = FontWeight.Bold)
        )


        Box(
            Modifier
                .fillMaxWidth()
                .padding(vertical = 33.dp)
        ) {
            Button(
                onClick = { /*TODO*/ },
                modifier = Modifier
                    .height(50.dp)
                    .fillMaxWidth()
                , shape = RoundedCornerShape(10.dp)
            ) {
                Text(text = "CONVERT", style = TextStyle(color = Color.Black,
                    fontStyle = FontStyle.Normal,))
            }

        }
    }

}
