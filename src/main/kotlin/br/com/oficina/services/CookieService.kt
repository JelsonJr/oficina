package br.com.oficina.services

import jakarta.servlet.http.Cookie
import jakarta.servlet.http.HttpServletRequest
import jakarta.servlet.http.HttpServletResponse

class CookieService {
    companion object {
        fun setCookie(response: HttpServletResponse, chave: String, valor: String, segundos: Int) {
            val cookie = Cookie(chave, valor)
            cookie.maxAge = segundos

            response.addCookie(cookie)
        }

        fun getCookie(request: HttpServletRequest, chave: String): String? {
            val cookie = request.cookies?.find { it.name == chave }
            return cookie?.value
        }
    }
}