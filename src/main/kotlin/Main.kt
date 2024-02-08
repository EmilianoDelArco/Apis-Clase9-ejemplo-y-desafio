import com.github.kittinunf.fuel.httpGet
import com.github.kittinunf.result.Result

fun main() {
    // URL de la API de JSONPlaceholder para obtener posts
    val apiUrl = "https://jsonplaceholder.typicode.com/posts"

    // Imprimir mensaje indicando que se está iniciando la solicitud a la API
    println("Iniciando la solicitud a la API...")

    // Realizar la solicitud GET a la API utilizando Fuel
    val (_, _, result) = apiUrl.httpGet().responseString()

    // Manejar el resultado de la solicitud
    when (result) {
        // Si la solicitud fue exitosa, imprimir la respuesta
        is Result.Success -> {
            val responseData = result.value
            println("Respuesta exitosa:")
            println(responseData)
        }
        // Si hubo un error en la solicitud, imprimir el mensaje de error
        is Result.Failure -> {
            val ex = result.error
            println("Error en la solicitud: $ex")
        }
    }

    // Imprimir mensaje indicando que el programa ha finalizado
    println("Fin del programa.")
}

//Ejemplo 2

//utilizando PokeApi
import com.github.kittinunf.fuel.httpGet
import com.github.kittinunf.result.Result

fun main() {
    // URL de la API de PokeAPI para obtener información de Pokémon
    val apiUrl = "https://pokeapi.co/api/v2/pokemon/1" // Puedes cambiar el número para obtener información sobre otro Pokémon

    // Imprimir mensaje indicando que se está iniciando la solicitud a la API
    println("Iniciando la solicitud a la PokeAPI...")

    // Realizar la solicitud GET a la API utilizando Fuel
    val (_, _, result) = apiUrl.httpGet().responseString()

    // Manejar el resultado de la solicitud
    when (result) {
        // Si la solicitud fue exitosa, imprimir la respuesta
        is Result.Success -> {
            val responseData = result.value
            println("Respuesta exitosa:")
            println(responseData)
        }
        // Si hubo un error en la solicitud, imprimir el mensaje de error
        is Result.Failure -> {
            val ex = result.error
            println("Error en la solicitud: $ex")
        }
    }

    // Imprimir mensaje indicando que el programa ha finalizado
    println("Fin del programa.")
}



//Desafio


//import com.github.kittinunf.fuel.httpGet
//import com.github.kittinunf.result.Result
import org.json.JSONObject

fun main() {
    // URL de la API de Mercado Libre para obtener información de un producto (cambia el ID del producto según tu elección)
    val productId = "MLA1430" // Reemplaza con el ID de un producto real de Mercado Libre
    val apiUrl = "https://api.mercadolibre.com/sites/MLA/search?category=$productId"

    // Imprimir mensaje indicando que se está iniciando la solicitud a la API de Mercado Libre
    println("Iniciando la solicitud a la API de Mercado Libre...")

    // Realizar la solicitud GET a la API de Mercado Libre utilizando Fuel
    val (_, _, result) = apiUrl.httpGet().responseString()

    // Manejar el resultado de la solicitud
    when (result) {
        // Si la solicitud fue exitosa, imprimir la respuesta formateada
        is Result.Success -> {
            val responseData = result.value
            val formattedJson = formatJson(responseData)
            println("Respuesta exitosa:")
            println(formattedJson)
        }
        // Si hubo un error en la solicitud, imprimir el mensaje de error
        is Result.Failure -> {
            val ex = result.error
            println("Error en la solicitud: $ex")
        }
    }

    // Imprimir mensaje indicando que el programa ha finalizado
    println("Fin del programa.")
}

// Función para formatear el JSON de manera legible
fun formatJson(jsonString: String): String {
    val jsonObject = JSONObject(jsonString)
    return jsonObject.toString(4) // El número 4 indica la cantidad de espacios para la indentación
}


//Es importante tener en cuenta esta dependencias
//dependencies {
//    implementation ("org.json:json:20211205")
//    implementation("com.github.kittinunf.fuel:fuel:2.3.1")
//    testImplementation("org.jetbrains.kotlin:kotlin-test")
//
//}
