package trpl.nim234311036.trofilmonitor

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.graphics.Color
import androidx.compose.foundation.background
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.ui.text.style.TextAlign

@Composable
fun AddClubScreen(onClubAdded: (Club) -> Unit) {
    var clubName by remember { mutableStateOf(TextFieldValue("")) }
    var premierLeague by remember { mutableStateOf(TextFieldValue("")) }
    var faCup by remember { mutableStateOf(TextFieldValue("")) }
    var eflCup by remember { mutableStateOf(TextFieldValue("")) }
    var championsLeague by remember { mutableStateOf(TextFieldValue("")) }
    var europaLeague by remember { mutableStateOf(TextFieldValue("")) }

    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(16.dp)
    ) {
        // Card untuk menampilkan form dalam kotak yang rapi
        Card(
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp),
            shape = RoundedCornerShape(12.dp),
            elevation = CardDefaults.cardElevation(8.dp)
        ) {
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(16.dp)
            ) {
                Text(
                    text = "Tambahkan Klub Baru",
                    fontSize = 24.sp,
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(bottom = 16.dp),
                    textAlign = TextAlign.Center
                )

                // Input untuk nama klub
                CustomInputField(
                    value = clubName,
                    onValueChange = { clubName = it },
                    label = "Nama Klub"
                )

                // Input untuk Premier League trofi
                CustomInputField(
                    value = premierLeague,
                    onValueChange = { premierLeague = it },
                    label = "Jumlah Premier League"
                )

                // Input untuk FA Cup trofi
                CustomInputField(
                    value = faCup,
                    onValueChange = { faCup = it },
                    label = "Jumlah FA Cup"
                )

                // Input untuk EFL Cup trofi
                CustomInputField(
                    value = eflCup,
                    onValueChange = { eflCup = it },
                    label = "Jumlah EFL Cup"
                )

                // Input untuk Champions League trofi
                CustomInputField(
                    value = championsLeague,
                    onValueChange = { championsLeague = it },
                    label = "Jumlah Champions League"
                )

                // Input untuk Europa League trofi
                CustomInputField(
                    value = europaLeague,
                    onValueChange = { europaLeague = it },
                    label = "Jumlah Europa League"
                )

                Spacer(modifier = Modifier.height(24.dp))

                // Tombol untuk menambahkan klub baru
                Button(
                    onClick = {
                        val club = Club(
                            name = clubName.text,
                            premierLeague = premierLeague.text.toIntOrNull(),
                            faCup = faCup.text.toIntOrNull(),
                            eflCup = eflCup.text.toIntOrNull(),
                            championsLeague = championsLeague.text.toIntOrNull(),
                            europaLeague = europaLeague.text.toIntOrNull()
                        )
                        onClubAdded(club)
                    },
                    modifier = Modifier.fillMaxWidth()
                ) {
                    Text("Tambah Klub")
                }
            }
        }
    }
}

@Composable
fun CustomInputField(
    value: TextFieldValue,
    onValueChange: (TextFieldValue) -> Unit,
    label: String
) {
    Column(modifier = Modifier.padding(bottom = 16.dp)) {
        Text(text = label, fontSize = 14.sp, color = Color.Gray)
        BasicTextField(
            value = value,
            onValueChange = onValueChange,
            modifier = Modifier
                .fillMaxWidth()
                .background(Color.LightGray, RoundedCornerShape(8.dp))
                .padding(8.dp),
            decorationBox = { innerTextField ->
                if (value.text.isEmpty()) {
                    Text(text = label, color = Color.Gray)
                }
                innerTextField()
            }
        )
    }
}
