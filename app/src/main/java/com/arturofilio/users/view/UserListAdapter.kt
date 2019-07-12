package com.arturofilio.users.view

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.arturofilio.users.R
import com.arturofilio.users.model.User
import com.arturofilio.users.util.getProgressDrawable
import com.arturofilio.users.util.loadImage
import kotlinx.android.synthetic.main.item_user.view.*

class UserListAdapter(var users: ArrayList<User>):
    RecyclerView.Adapter<UserListAdapter.UserViewHolder>() {

    fun updateUsers(newUsers: List<User>) {
        users.clear()
        users.addAll(newUsers)
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, p1: Int) = UserViewHolder (
        LayoutInflater.from(parent.context).inflate(R.layout.item_user,parent,false)
    )

    override fun getItemCount() = users.size

    override fun onBindViewHolder(holder: UserViewHolder, position: Int) {
        holder.bind(users[position])
    }

    class UserViewHolder(view: View): RecyclerView.ViewHolder(view) {
        private val imageView = view.imageView
        private val userFirstName = view.first_name
        private val userLastName = view.last_name
        private val progressDrawable = getProgressDrawable(view.context)

        fun bind(user: User) {
            userFirstName.text = user.firstName
            userLastName.text = user.lastName
            imageView.loadImage(user.userImage, progressDrawable)
        }

    }

}