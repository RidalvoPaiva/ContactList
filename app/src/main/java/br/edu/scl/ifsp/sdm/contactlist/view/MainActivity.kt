package br.edu.scl.ifsp.sdm.contactlist.view

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import br.edu.scl.ifsp.sdm.contactlist.R

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val recyclerView = findViewById<RecyclerView>(R.id.recyclerViewContacts)
        recyclerView.layoutManager = LinearLayoutManager(this)

        // Adicionar divisórias entre os itens
        recyclerView.addItemDecoration(
            DividerItemDecoration(this, DividerItemDecoration.VERTICAL)
        )

        val contacts = listOf(
            Contact("Joana", "joana@gmail.com", "(11) 99999-1111"),
            Contact("Nilda", "nilda@gmail.com", "(11) 99999-2222"),
            Contact("João Silva", "joao@email.com", "(11) 99999-1111"),
            Contact("Maria Santos", "maria@email.com", "(11) 99999-2222"),
            Contact("Pedro Costa", "pedro@email.com", "(11) 99999-3333"),
            Contact("Ana Oliveira", "ana@email.com", "(11) 99999-4444"),
            Contact("Carlos Souza", "carlos@email.com", "(11) 99999-5555"),
            Contact("Juliana Lima", "juliana@email.com", "(11) 99999-6666")
        )

        val adapter = ContactAdapter(contacts) { contact ->
            // Funcionalidade de ligação
            val intent = Intent(Intent.ACTION_DIAL).apply {
                data = Uri.parse("tel:${contact.phone.filter { it.isDigit() }}")
            }
            startActivity(intent)
        }

        recyclerView.adapter = adapter
    }
}