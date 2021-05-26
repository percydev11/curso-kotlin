//Declaramos los valores de las respuestas
const val RESPUESTA_AFIRMATIVA = " ✅ "
const val RESPUESTA_NEGATIVA = " ❌ "
const val RESPUESTA_DUDOSA = " ? "

//Unimos las respuestas con los valores
val respuestas = mapOf(
    "Si" to RESPUESTA_AFIRMATIVA,
    "Es cierto" to RESPUESTA_AFIRMATIVA,
    "Totalmente" to RESPUESTA_AFIRMATIVA,
    "Pregunta en otro momento" to RESPUESTA_DUDOSA,
    "No puedo decirte en este momento" to RESPUESTA_DUDOSA,
    "Puede que sí o puede que no" to RESPUESTA_DUDOSA,
    "No va a suceder" to RESPUESTA_NEGATIVA,
    "No cuentes con ello" to RESPUESTA_NEGATIVA,
    "Definitivamente no" to RESPUESTA_NEGATIVA,
    "No lo creo" to RESPUESTA_NEGATIVA,
)


fun main(args: Array<String>) {
    //Menú
    do {
        println()
        println("Hola soy tu bola mágica creada en Kotlin. ¿Cuál de éstas opciones deseas realizar?")
        println("1. Realizar una pregunta")
        println("2. Revisar todas las respuestas")
        println("3. Salir")

        //Obtener valor desde la consola
        val valorIngresado = readLine()
        when (valorIngresado) {
            "1" -> realizarPregunta()
            "2" -> mostrarRespuestas()
            "3" -> salir()
            else -> mostrarError()
        }
    } while (valorIngresado != "3")

}

fun mostrarError() {
    println("Vaya parece que has elegido una opción no válida, intenta de nuevo")
}

fun salir() {
    println("Hasta luego!!")
}

fun mostrarRespuestas() {
    do {
        println()
        println("Selecciona una opción:")
        println("1. Revisar todas las respuestas")
        println("2. Revisar sólo las respuestas afirmativas")
        println("3. Revisar sólo las respuestas dudosas")
        println("4. Revisar sólo las respuestas negativas")
        //Obtener la opción ingresada
        val opcionIngresada = readLine()
        when (opcionIngresada) {
            "1" -> mostrarRespPorTipo()
            //Uso de parámetros nombrados
            "2" -> mostrarRespPorTipo(tipoDeRespuesta = RESPUESTA_AFIRMATIVA)
            "3" -> mostrarRespPorTipo(tipoDeRespuesta = RESPUESTA_DUDOSA)
            "4" -> mostrarRespPorTipo(tipoDeRespuesta = RESPUESTA_NEGATIVA)
            else -> println("Respuesta no válida. Intenta de nuevo")

        }
    }while (opcionIngresada != "4")

}

fun mostrarRespPorTipo(tipoDeRespuesta: String = "TODOS") {

    val lambda: (String) -> Map<String, String> = { claseRespuesta: String ->
        respuestas.filterValues { valor -> valor == claseRespuesta }.also { respuesta: Map<String, String> -> println(respuesta.keys) }
    }

    when (tipoDeRespuesta) {

        "TODOS" -> respuestas.keys.forEach { respuesta -> println(respuesta) }

        RESPUESTA_AFIRMATIVA -> lambda(RESPUESTA_AFIRMATIVA)

        RESPUESTA_NEGATIVA -> lambda(RESPUESTA_NEGATIVA)

        RESPUESTA_DUDOSA -> lambda(RESPUESTA_DUDOSA)
    }
}

fun realizarPregunta() {
    println("¿Qué pregunta deseas realizar?")
    readLine()
    println("Así que esa era tu pregunta...La respuesta a eso es:")
    //Elegir una respuesta del mapa al azar con random()
    val respuestaGenerada = respuestas.keys.random()
    println(respuestaGenerada)
}


