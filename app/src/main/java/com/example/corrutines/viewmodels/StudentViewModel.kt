package com.example.corrutines.viewmodels

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.corrutines.models.Student
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import java.lang.Exception

class StudentViewModel:ViewModel() {

    var selectedStudent by mutableStateOf("") //sera el nombre del estudiante
    var enabledButton by mutableStateOf(true)

    fun getData(){
        //iniciar corrutina
        viewModelScope.launch{
            enabledButton = false
            //aqui logica de nuestro hilo
            selectedStudent = "Buscando estudiante afortunado"
            try {
                getRandomStudent()
            }catch(e: Exception){
                selectedStudent = "Error procesando el hilo"
            }finally{
                enabledButton = true
            }


        }
    }

    suspend fun getRandomStudent(){
        val studentName:String = withContext(Dispatchers.IO){
            delay(5000)
            //bloque de codigo que estara en subproceso para no congelas la interfaz de usuario
            var list = mutableListOf<Student>()
            list.add(Student(1,"Josue David",true))
            list.add(Student(2,"Alfonso Estudiante",true))
            list.add(Student(3,"David Alejandro",true))
            list.add(Student(4,"Sebastian Rubio",true))
            list.add(Student(5,"Gerardo Torres",true))
            list.add(Student(6,"Raymundo Dolhpins",false))
            list.add(Student(7,"Maria Fernanda",true))
            list.add(Student(8,"Javier Zapata",true))
            list.add(Student(9,"Edson Maya",true))
            list.add(Student(10,"Aylin Alvarez",true))
            list.add(Student(11,"Yoselin Mojica",true))
            list.random().name
        }
        selectedStudent = studentName
    }

}