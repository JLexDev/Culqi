package com.god8first.culqi.components

import android.util.Log
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.ClickableText
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.blur
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.god8first.culqi.domain.response.ColorItem
import com.god8first.culqi.ui.theme.CulqiTheme

/**
 * @author Alexander Ramírez on 20/07/2024.
 * ·
 * @JLexDev - 1jlex3@gmail.com
 **/
 
@Composable
fun ImageComponent(image: Int) {
    Image(
        painter = painterResource(id = image),
        contentDescription = null,
        modifier = Modifier.fillMaxSize(),
        contentScale = ContentScale.Crop
    )
}

@Composable
fun HeadingTextComponent(title: String) {
    Text(
       text = title,
        modifier = Modifier
            .fillMaxWidth()
            .padding(16.dp),
        fontSize = 30.sp,
        color = Color.White,
        fontWeight = FontWeight.Bold
    )
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MyTextField(label: String, onValueChange: (String) -> Unit) {
    var text by remember {
        mutableStateOf("")
    }
    /*val typeOfKeyboard: KeyboardType = when(label) {
        "email" -> KeyboardType.Email
        //"name" -> KeyboardType.Text
        else -> KeyboardType.Text
    }
    val typeOfIme: ImeAction = when(label) {
        "email" -> ImeAction.Next
        //"password" -> ImeAction.Done
        else -> ImeAction.Done
    }*/

    OutlinedTextField(
        value = text,
        onValueChange = {
            text = it
            onValueChange(it)
        },
        modifier = Modifier
            .fillMaxWidth()
            .border(2.dp, Color.Transparent),
        colors = TextFieldDefaults.outlinedTextFieldColors(
            focusedBorderColor = MaterialTheme.colorScheme.tertiary,
            unfocusedBorderColor = Color.LightGray,
            containerColor = Color.White,
            focusedLeadingIconColor = Color.DarkGray,
            unfocusedLeadingIconColor = Color.LightGray,
            cursorColor = Color.DarkGray
        ),
        shape = MaterialTheme.shapes.small,
        placeholder = {
            Text(text = label, color = Color.LightGray)
        },
        /*leadingIcon = {
            Icon(
                painter = painterResource(id = icon),
                contentDescription = "at_symbol"
            )
        },*/
        keyboardOptions = KeyboardOptions(
            keyboardType = KeyboardType.Email, //typeOfKeyboard,
            imeAction = ImeAction.Next //typeOfIme
        ),
        singleLine = true
    )
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun PasswordInputComponent(label: String, onValueChange: (String) -> Unit) {
    var password by remember {
        mutableStateOf("")
    }
    var isShowPassword by remember {
        mutableStateOf(false)
    }

    OutlinedTextField(
        value = password,
        onValueChange = {
            password = it
            onValueChange(it)
        },
        modifier = Modifier.fillMaxWidth(),
        colors = TextFieldDefaults.outlinedTextFieldColors(
            focusedBorderColor = MaterialTheme.colorScheme.tertiary,
            unfocusedBorderColor = Color.LightGray,
            containerColor = Color.White,
            cursorColor = Color.DarkGray
        ),
        shape = MaterialTheme.shapes.small,
        placeholder = {
            Text(text = label, color = Color.LightGray)
        },
        /*leadingIcon = {
            Icon(
                painter = painterResource(id = androidx.core.R.drawable.ic_call_answer),
                contentDescription = "lock",
                tint = Color.Gray
            )
        },*/
        trailingIcon = {
            val description = if(isShowPassword) "Ocultar" else "Ver"
            TextButton(
                onClick = { isShowPassword = !isShowPassword }
            ) {
                Text(
                    text = description,
                    color = Color.DarkGray,
                    textDecoration = TextDecoration.None
                )
            }
        },
        keyboardOptions = KeyboardOptions(
            keyboardType = KeyboardType.Password,
            imeAction = ImeAction.Done
        ),
        visualTransformation = if(isShowPassword) VisualTransformation.None else PasswordVisualTransformation()
    )
}

@Composable
fun MyButtonComponent(label: String, onClick: () -> Unit) {
    Button(
        onClick = { onClick() },
        colors = ButtonDefaults.buttonColors(
            containerColor = MaterialTheme.colorScheme.tertiary
        ),
        modifier = Modifier
            .fillMaxWidth()
            .height(50.dp),
        shape = MaterialTheme.shapes.small, //RoundedCornerShape(10.dp)
    ) {
        Text(
            text = label,
            color = Color.White,
            fontSize = 18.sp
        )
    }
}

@Composable
fun SocialNetworkButtonComponent(label: String, icon: Int) {
    Button(
        onClick = { /*TODO*/ },
        colors = ButtonDefaults.outlinedButtonColors(
            containerColor = Color.White
        ),
        modifier = Modifier
            .fillMaxWidth()
            .height(50.dp),
        shape = MaterialTheme.shapes.small
    ) {
        Row(
            modifier = Modifier.fillMaxWidth(),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Image(
                painter = painterResource(id = icon),
                contentDescription = "$label icon"
            )
            Text(
                text = "Continuar con $label",
                fontSize = 16.sp,
                color = Color.Black,
                textAlign = TextAlign.Center,
                fontWeight = FontWeight.Bold,
                modifier = Modifier.fillMaxWidth()
            )
        }

    }
}

@Composable
fun TextClickableComponent(label: String, onClick: () -> Unit) {
    Text(
        text = label,
        color = MaterialTheme.colorScheme.tertiary,
        fontSize = 16.sp,
        fontWeight = FontWeight.Bold,
        modifier = Modifier
            .clickable { onClick() }
    )
}

@Composable
fun TextSpanClickableComponent(initialText: String, clickableText: String, onClick: () -> Unit) {
    val annotatedString = buildAnnotatedString {
        withStyle(
            style = SpanStyle(
                color = Color.White,
                fontSize = 14.sp
            )) {
            append(initialText)
        }
        withStyle(
            style = SpanStyle(
                color = MaterialTheme.colorScheme.tertiary,
                fontSize = 14.sp,
                fontWeight = FontWeight.Bold
            )) {
            pushStringAnnotation(tag = clickableText, annotation = clickableText)
            append(clickableText)
        }
    }

    ClickableText(text = annotatedString, onClick = {
        annotatedString.getStringAnnotations(it, it)
            .firstOrNull()?.also { span ->
                Log.d("SignUpTermAndPrivacy", span.item)
                onClick()
            }
    })
}

@Composable
fun UsernameComponent(avatarId: Int, name: String, email: String) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
    ) {
        Image(
            painter = painterResource(id = avatarId),
            contentDescription = "Profile Image",
            contentScale = ContentScale.Crop,
            modifier = Modifier
                .size(64.dp)
                .clip(CircleShape)
                //.border(2.dp, Color.Gray, CircleShape)
        )
        Spacer(modifier = Modifier.width(16.dp))
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(vertical = 8.dp)
        ) {
            Text(
                text = name,
                fontSize = 14.sp,
                fontWeight = FontWeight.Bold
            )
            Text(
                text = email,
                fontSize = 14.sp,
            )
        }
    }
}

@Composable
fun BlurredBackgroundComponent(content: @Composable () -> Unit) {
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .background(
                color = Color.DarkGray.copy(alpha = 0.5f),
                shape = RoundedCornerShape(10.dp)
            )
            .padding(20.dp)
            .blur(20.dp)
    ) {
        content()
    }
}

val myTextColorItemStyle = TextStyle(
    color = Color.Black,
    fontSize = 14.sp,
    fontWeight = FontWeight.SemiBold
)

@Composable
fun MyResourceItemComponent(data: ColorItem) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 40.dp, vertical = 20.dp)
            .background(Color.White)
    ) {
        Box(
            modifier = Modifier
                .size(80.dp)
                .background(
                    color = Color(android.graphics.Color.parseColor(data.color)),
                    shape = RoundedCornerShape(8.dp)
                ),
            contentAlignment = Alignment.Center
        ) {
            Text(
                text = "${data.color}",
                color = Color.White,
                fontSize = 14.sp,
                fontWeight = FontWeight.Bold,
                textAlign = TextAlign.Center
            )
        }
        Spacer(modifier = Modifier.width(16.dp))
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(5.dp)
        ) {
            Text(text = "ID: ${data.id}", style = myTextColorItemStyle)
            Text(text = "Nombre: ${data.name.replaceFirstChar { it.uppercaseChar() }}", style = myTextColorItemStyle)
            Text(text = "Año: ${data.year}", style = myTextColorItemStyle)
            Text(text = "Valor Pantone: ${data.pantoneValue}", style = myTextColorItemStyle)
        }
    }
}


@Composable
fun LoadingComponent() {
    Box(
        modifier = Modifier.fillMaxSize(),
        contentAlignment = Alignment.Center
    ) {
        CircularProgressIndicator( // Fix version
            color = MaterialTheme.colorScheme.tertiary,
            strokeWidth = 4.dp,
            modifier = Modifier.size(30.dp)
        )
    }
}




/*
  PREVIEW
 */
@Preview(showBackground = true)
@Composable
fun ComponentsPreview() {
    CulqiTheme {
        //ImageComponent(image = R.drawable.ic_culqi_background)
        //HeadingTextComponent(title = "Sign In")
        //MyTextField(label = "email"/*, icon = R.drawable.ic_launcher_foreground*/)
        //PasswordInputComponent(label = "password")
        //MyButton(label = "Continuar"/*, navController = */)
        //SocialNetworkButton(label = "Google", icon = R.drawable.ic_google)
        /*TextSpanClickable(
            initialText = "Seleccionando Acepto y continuar, estás de acuerdo con los ",
            clickableText = "Términos de Servicio y Política de Privacidad"
        )*/
    }
}