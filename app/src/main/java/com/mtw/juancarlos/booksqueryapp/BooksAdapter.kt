package com.mtw.juancarlos.booksqueryapp

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.bumptech.glide.Glide
import com.mtw.juancarlos.booksqueryapp.data.Book
import kotlinx.android.synthetic.main.book_card_item.view.*

class BooksAdapter(booksList: List<Book>, listener: OnItemClickListener) : RecyclerView.Adapter<BooksAdapter.BooksViewHolder>() {

    private var listBooks: List<Book> = booksList

    private var listenerBook: OnItemClickListener = listener


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BooksViewHolder {
        return BooksViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.book_card_item, parent, false))
    }


    override fun onBindViewHolder(holder: BooksViewHolder, position: Int) {
        var current: Book = listBooks[position]

        holder.bind(current, listenerBook)
    }

    override fun getItemCount() = listBooks.size

    interface OnItemClickListener {
        fun onItemClick(book: Book)
    }

    fun setBooks(books:List<Book>){
        listBooks = books
        notifyDataSetChanged()
    }

    class BooksViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        fun bind(book: Book, listener: OnItemClickListener) {
            itemView.tvTitle.text = book.title
            itemView.tvAuthor.text = book.authors.joinToString(",")
            Glide.with(itemView.context).load(book.image).into(itemView.imgCover)

            itemView.setOnClickListener {
                listener.onItemClick(book)
            }
        }

    }
}