package co.ghostnotes.sample.list.dnd

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.VibrationEffect
import android.os.Vibrator
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.ItemTouchHelper
import androidx.recyclerview.widget.ItemTouchHelper.SimpleCallback
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import co.ghostnotes.sample.list.dnd.MainActivity.DndAdapter.DndViewHolder
import co.ghostnotes.sample.list.dnd.databinding.ActivityMainBinding
import co.ghostnotes.sample.list.dnd.databinding.ListItemUserBinding
import co.ghostnotes.sample.list.dnd.extension.bindView

class MainActivity : AppCompatActivity(R.layout.activity_main) {

    private lateinit var binding: ActivityMainBinding
    private lateinit var adapter: DndAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = bindView()

        adapter = DndAdapter(createUsers())
        binding.recyclerView.apply {
            layoutManager = LinearLayoutManager(context)
            addItemDecoration(DividerItemDecoration(context, DividerItemDecoration.VERTICAL))
            this.adapter = this@MainActivity.adapter
        }

        val itemTouchHelper = ItemTouchHelper(
            object : SimpleCallback(
                ItemTouchHelper.UP or ItemTouchHelper.DOWN,
                ItemTouchHelper.LEFT
            ) {
                override fun onMove(
                    recyclerView: RecyclerView,
                    viewHolder: RecyclerView.ViewHolder, target: RecyclerView.ViewHolder
                ): Boolean {
                    val fromPos = viewHolder.adapterPosition
                    val toPos = target.adapterPosition
                    // move item in `fromPos` to `toPos` in adapter.
                    adapter.notifyItemMoved(fromPos, toPos)
                    return true // true if moved, false otherwise
                }

                override fun onSwiped(viewHolder: RecyclerView.ViewHolder, direction: Int) {
                    // remove from adapter
                }
            })
        itemTouchHelper.attachToRecyclerView(binding.recyclerView)
    }

    private fun createUsers(): List<User> {
        return listOf(
            User(1, "Aaa Bbb", 18),
            User(2, "Ccc Ddd", 23),
            User(3, "Eee Fff", 44),
            User(4, "Ggg Hhh", 22),
            User(5, "Iii Jjj", 55),
            User(6, "Aaa Bbb", 18),
            User(7, "Ccc Ddd", 23),
            User(8, "Eee Fff", 44),
            User(9, "Ggg Hhh", 22),
            User(10, "Iii Jjj", 55),
            User(11, "Aaa Bbb", 18),
            User(12, "Ccc Ddd", 23),
            User(13, "Eee Fff", 44),
            User(14, "Ggg Hhh", 22),
            User(15, "Iii Jjj", 55),
            User(16, "Iii Jjj", 55),
            User(17, "Iii Jjj", 55),
            User(18, "Iii Jjj", 55),
            User(19, "Iii Jjj", 55),
            User(20, "Iii Jjj", 55),
        )
    }

    private class DndAdapter(val users: List<User>) : RecyclerView.Adapter<DndViewHolder>() {

        override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): DndViewHolder {
            val binding = ListItemUserBinding.inflate(LayoutInflater.from(parent.context), parent, false)
            return DndViewHolder(binding)
        }

        override fun onBindViewHolder(holder: DndViewHolder, position: Int) {
            holder.bind(users[position])
        }

        override fun getItemCount(): Int {
            return users.size
        }

        private class DndViewHolder(private val binding: ListItemUserBinding) : RecyclerView.ViewHolder(binding.root) {
            fun bind(user: User) {
                binding.user = user
            }
        }
    }
}