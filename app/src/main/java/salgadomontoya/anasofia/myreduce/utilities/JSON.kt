package salgadomontoya.anasofia.myreduce.utilities

import android.content.Context
import android.util.Log
import java.io.IOException

class JSON {

    val MY_REDUCE  = "data.json"
    constructor(){
    }

    fun saveData(context: Context, json: String){
        try{
            context.openFileOutput(MY_REDUCE, Context.MODE_PRIVATE).use {
                it.write(json.toByteArray())
            }
        } catch (e: IOException){
            Log.e("Guardar", "Error in Writing: " + e.localizedMessage)
        }
    }
    fun getData(context: Context): String{
        try{
            return context.openFileInput(MY_REDUCE).bufferedReader().readLine()

        } catch (e: IOException){
            Log.e("OBTENER", "Error in Fetching data: " + e.localizedMessage)
            return ""
        }
    }
}