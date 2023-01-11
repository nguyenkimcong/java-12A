package com.example.miniproject.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Todo {
    private int id;
    private String title;
    private boolean status;
}

// B1 : Thêm dependence
// B2 : Thêm cấu hình db trong file application.properties
// B3 : Sửa tạo model todo => entity
// B4 : Chạy lại ứng dụng để kiểm tra xem đã tạo table hay chưa
// B5 : Tạo TodoRepository
// B6 : Sửa lại TodoService
