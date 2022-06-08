# Rau củ xanh
Giao diện figma : https://www.figma.com/file/E0De1xfGd9dewDaw1Shi1b/Rau-c%E1%BB%A7-xanh?node-id=2%3A2 <br>
Backend demo login : https://github.com/mcbutt007/Rau-cu-xanh-backend <br>
Chức năng : https://docs.google.com/spreadsheets/d/1w80mBDcXp8sWXuKkYtednBwKxqv1SHWFd2pq2dwLTG8/edit#gid=0 <br>

## Tóm tắt thiết kế app:
Thư mục layout : Chứa các màn hình giao diện
+ fragment : mảnh giao diện
+ activity : hoạt động cụ thể. Chứa điều hướng (navigation) và mảnh giao diện tương ứng của điều hướng. Tạm thời có 2 hoạt động là login (chỉ chứa phần login, đk tài khoản, quên mk) và main (chứa mọi thứ còn lại khi người dùng đã đăng nhập)

		Thư mục ui : chứa điều khiển các màn hình giao diện.
+ fragment : logic điền khiển mảnh tương ứng
+ activity & viewmodel : chưa cần quan tâm đến

		Khác
- Thư mục navigation : chứa điều hướng của các hoạt động
- Thư mục network : chứa các api
- Thư mục model chứa các đối tượng

### Phần login :
- app gửi post request đến server chứa thông tin đã nhập
- Xác thực đăng nhập: app gửi username & password đến backend. Nếu trùng khớp với username và password của csdl server sẽ trả về ID người dùng, app sẽ lưu id đó để làm việc với thao tác sau. Vd ( đổi thông tin nguời dùng, lấy thông tin giỏ hàng của người dùng, hóa đơn của người dùng, vv )
- quên mật khẩu : email người dùng gửi sẽ đc thêm vào csdl bảng quên mật khẩu
- Đăng ký : Thông tin đăng ký người dùng gửi sẽ đc thêm vào csdl

		Tiến độ app:
- Đăng nhập flow : Hoàn thành
- Thay đổi thông tin người dùng : Dự kiến xong 14/5/2022(Phúc)
- Còn lại : UI con 1 số lỗi hiển thị, tạm xong điều hướng, chưa làm phần logic, đổ dữ liệu.

		Tiến độ backend :
- Đăng nhập : hoàn thành với csdl thử nghiệm
- cdsl : chưa có
- còn lại : chưa hoàn thành

## Task
- CSDL của backend
- Backend cho dữ liệu mẫu để sử dụng trên app 
- Thay đổi thông tin người dùng
- Lấy dữ liệu từ server và bỏ vào app
- Trang chủ
- Hóa đơn
- Chi tiết hóa đơn
- Giỏ hàng
- Sản phẩm
- Đánh giá
- Tìm kiếm
- Thống kê

## Hướng làm:
- Trang chủ, Sản phẩm, đánh giá, tìm kiếm : gửi request lấy dữ liệu như phần login & đọc json từ backend và đổ vào view
- Giỏ hàng, hóa đơn, chi tiết hóa đơn, thống kê : trong request có user id, còn lại giống trang chủ


## Cải tiến nếu có thời gian
- Setup csdl để cache trên app
- Recycler view
- Cải tiến lại UI
- Refactor code
- Áp dụng kiến trúc Viewmodel factory 
- Xử lý background & thread & coroutine

