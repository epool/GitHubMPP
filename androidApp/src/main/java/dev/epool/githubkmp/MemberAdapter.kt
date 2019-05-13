package dev.epool.githubkmp

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.squareup.picasso.Picasso
import dev.epool.model.Member
import kotlinx.android.synthetic.main.list_item_member.view.*

class MemberAdapter(
    var members: List<Member>
) : RecyclerView.Adapter<MemberAdapter.MemberViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) = MemberViewHolder(parent)

    override fun getItemCount() = members.size

    override fun onBindViewHolder(holder: MemberViewHolder, position: Int) =
        holder.bind(members[position])

    class MemberViewHolder(parent: ViewGroup) : RecyclerView.ViewHolder(
        LayoutInflater.from(parent.context).inflate(R.layout.list_item_member, parent, false)
    ) {

        fun bind(member: Member) {
            with(itemView) {
                Picasso.get().load(member.avatarUrl).into(memberAvatar)
                memberLogin.text = member.login
            }
        }

    }

}