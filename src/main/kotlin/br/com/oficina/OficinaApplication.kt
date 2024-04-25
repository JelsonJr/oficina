package br.com.oficina

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication()
class OficinaApplication

fun main(args: Array<String>) {
    runApplication<OficinaApplication>(*args)
}
