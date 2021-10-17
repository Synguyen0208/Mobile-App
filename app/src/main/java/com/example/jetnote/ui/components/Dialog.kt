import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.text.input.KeyboardType
import com.example.jetnote.R
import com.example.jetnote.ui.components.MyTextField

@Composable
fun MyAlertDialog() {
    val shouldShowDialog = remember { mutableStateOf(false) }
    FloatingActionButton(
        backgroundColor = Color.Yellow,
        onClick = {
            shouldShowDialog.value = true
        }
    )
    {
        Text("New account")
    }
    if (shouldShowDialog.value) {
        val user_name=remember {mutableStateOf("")};
        val email=remember {mutableStateOf("")};
        val password=remember {mutableStateOf("")};
        val confPassword=remember {mutableStateOf("")};
        val error=remember {mutableStateOf("")};
        AlertDialog(
            onDismissRequest = {
                shouldShowDialog.value = false
            },
            title = { Text(text = "Create account") },
            text = {

                Column() {
                    MyTextField(label = "User name", field =user_name, KeyboardType.Text);
                    MyTextField(label = "Email", field=email, KeyboardType.Email);
                    MyTextField(label = "Password", field = password, KeyboardType.Password);
                    MyTextField(label = "Confirm password", field = confPassword, KeyboardType.Password);
                    Text(text =error.value, color = Color.Red);
                    Row() {
                        val checked= remember {
                            mutableStateOf(false)
                        };
                        Checkbox(
                            checked = checked.value,
                            onCheckedChange ={
                            checked.value=!checked.value
                            }
                        );
                        Text(text = "Agree to our privacy policy")
                    }
                }
                   
            },
            confirmButton = {
                Button(
                    colors = ButtonDefaults.buttonColors(
                        backgroundColor = colorResource(id = R.color.colorPrimary)
                    ),
                    onClick = {
                        if(user_name.value==""){
                            error.value="User name cannot be empty"
                        }else
                        if(email.value==""){
                            error.value="Email cannot be empty"
                        }else
                        if(password.value==""){
                            error.value="Password cannot be empty"
                        }else
                        if(password.value==confPassword.value){
                            shouldShowDialog.value = false
                        }
                        else{
                            error.value="Password does not match"
                        }
                    }
                )
                {
                    Text(text = "Submit", color = Color.White)
                }
            }
        )
    }
}