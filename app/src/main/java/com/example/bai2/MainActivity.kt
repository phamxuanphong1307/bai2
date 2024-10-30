package com.example.bai2

import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.widget.EditText
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity() {

    private lateinit var edtSearch: EditText
    private lateinit var recyclerView: RecyclerView
    private lateinit var adapter: SinhVienAdapter
    private lateinit var sinhVienList: MutableList<SinhVien>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // Ánh xạ các view
        edtSearch = findViewById(R.id.edtSearch)
        recyclerView = findViewById(R.id.recyclerView)

        // Khởi tạo danh sách sinh viên
        sinhVienList = mutableListOf(
            SinhVien("Nguyen Van A", "20210001"),
            SinhVien("Tran Thi B", "20210002"),
            SinhVien("Le Van C", "20210003"),
            SinhVien("Pham Thi D", "20210004"),
            SinhVien("Hoang Van E", "20210005"),
            SinhVien("Bui Van F", "20210006"),
            SinhVien("Do Thi G", "20210007"),
            SinhVien("Ngo Van H", "20210008"),
            SinhVien("Vo Thi I", "20210009"),
            SinhVien("Truong Van J", "20210010"),
            SinhVien("Nguyen Thi K", "20210011"),
            SinhVien("Tran Van L", "20210012"),
            SinhVien("Le Thi M", "20210013"),
            SinhVien("Pham Van N", "20210014"),
            SinhVien("Hoang Thi O", "20210015"),
            SinhVien("Bui Thi P", "20210016"),
            SinhVien("Do Van Q", "20210017"),
            SinhVien("Ngo Thi R", "20210018"),
            SinhVien("Vo Van S", "20210019"),
            SinhVien("Truong Thi T", "20210020"),
            SinhVien("Nguyen Van U", "20210021"),
            SinhVien("Tran Thi V", "20210022"),
            SinhVien("Le Van W", "20210023"),
            SinhVien("Pham Thi X", "20210024"),
            SinhVien("Hoang Van Y", "20210025"),
            SinhVien("Bui Thi Z", "20210026"),
            SinhVien("Do Van AA", "20210027"),
            SinhVien("Ngo Thi AB", "20210028"),
            SinhVien("Vo Van AC", "20210029"),
            SinhVien("Truong Thi AD", "20210030"),
            SinhVien("Nguyen Van AE", "20210031"),
            SinhVien("Tran Thi AF", "20210032"),
            SinhVien("Le Van AG", "20210033"),
            SinhVien("Pham Thi AH", "20210034"),
            SinhVien("Hoang Van AI", "20210035"),
            SinhVien("Bui Thi AJ", "20210036"),
            SinhVien("Do Van AK", "20210037"),
            SinhVien("Ngo Thi AL", "20210038"),
            SinhVien("Vo Van AM", "20210039"),
            SinhVien("Truong Thi AN", "20210040"),
            SinhVien("Nguyen Van AO", "20210041"),
            SinhVien("Tran Thi AP", "20210042"),
            SinhVien("Le Van AQ", "20210043"),
            SinhVien("Pham Thi AR", "20210044"),
            SinhVien("Hoang Van AS", "20210045"),
            SinhVien("Bui Thi AT", "20210046"),
            SinhVien("Do Van AU", "20210047"),
            SinhVien("Ngo Thi AV", "20210048"),
            SinhVien("Vo Van AW", "20210049"),
            SinhVien("Truong Thi AX", "20210050")
        )

        // Thiết lập RecyclerView
        adapter = SinhVienAdapter(sinhVienList)
        recyclerView.layoutManager = LinearLayoutManager(this)
        recyclerView.adapter = adapter

        // Xử lý sự kiện khi nhập vào ô tìm kiếm
        edtSearch.addTextChangedListener(object : TextWatcher {
            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {}

            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
                val keyword = s.toString()
                if (keyword.length >= 2) {
                    // Tìm kiếm khi từ khóa dài hơn 2 ký tự
                    val filteredList = sinhVienList.filter {
                        it.hoTen.contains(keyword, ignoreCase = true) ||
                                it.mssv.contains(keyword, ignoreCase = true)
                    }
                    adapter.updateList(filteredList)
                } else {
                    // Hiển thị toàn bộ danh sách nếu từ khóa ngắn hơn 2 ký tự
                    adapter.updateList(sinhVienList)
                }
            }

            override fun afterTextChanged(s: Editable?) {}
        })
    }
}
