package br.edu.scl.ifsp.sdm.contactlist.view

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageButton
import android.widget.TextView
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import br.edu.scl.ifsp.sdm.contactlist.R

class ContactAdapter(
    private val contacts: List<Contact>,
    private val onCallClick: (Contact) -> Unit
) : RecyclerView.Adapter<ContactAdapter.ViewHolder>() {

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val tvName: TextView = itemView.findViewById(R.id.tvName)
        val tvEmail: TextView = itemView.findViewById(R.id.tvEmail)
        val tvPhone: TextView = itemView.findViewById(R.id.tvPhone)
        val btnCall: ImageButton = itemView.findViewById(R.id.btnCall)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.contact_item, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val contact = contacts[position]

        holder.tvName.text = contact.name
        holder.tvEmail.text = contact.email
        holder.tvPhone.text = contact.phone


        holder.btnCall.setOnClickListener {
            onCallClick(contact)
        }

        // Efeito de clique em todo o item
        holder.itemView.setOnClickListener {
            // Aqui pode abrir detalhes do contato
            Toast.makeText(holder.itemView.context,
                "Clicou em: ${contact.name}", Toast.LENGTH_SHORT).show()
        }
    }

    override fun getItemCount(): Int = contacts.size
}