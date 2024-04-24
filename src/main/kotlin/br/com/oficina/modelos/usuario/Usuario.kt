package br.com.oficina.modelos.usuario

import br.com.oficina.modelos.veiculo.Veiculo
import jakarta.persistence.*
import org.springframework.security.core.GrantedAuthority
import org.springframework.security.core.authority.SimpleGrantedAuthority
import org.springframework.security.core.userdetails.UserDetails

@Entity
class Usuario(
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long? = null,
    val nome: String = "",
    val email: String = "",
    val cpf: String = "",
    val senha: String = "",
    val telefone: String? = null,

    @OneToMany
    val veiculos: MutableList<Veiculo> = mutableListOf<Veiculo>()
) : UserDetails {

    override fun getAuthorities(): MutableCollection<out GrantedAuthority> =
        mutableListOf(SimpleGrantedAuthority("ROLE_USER"))

    override fun getPassword(): String = this.senha

    override fun getUsername(): String = this.email

    override fun isAccountNonExpired(): Boolean = true

    override fun isAccountNonLocked(): Boolean = true

    override fun isCredentialsNonExpired(): Boolean = true

    override fun isEnabled(): Boolean = true

    override fun toString(): String {
        return "Usuario: $nome, $email, $telefone, $cpf, $veiculos"
    }
}
