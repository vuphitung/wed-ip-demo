document.getElementById('next-button').addEventListener('click', function() {
    var emailPhoneInput = document.getElementById('email-phone');
    if (emailPhoneInput.value.trim() !== '') {
        // Hiển thị phần mật khẩu và nút submit, ẩn nút next
        document.getElementById('password-container').classList.remove('hidden');
        document.getElementById('next-button').style.display = 'none'; // Ẩn nút next
        document.getElementById('submit-button').classList.remove('hidden');
    } else {
        alert('Vui lòng nhập Email hoặc số điện thoại');
    }
});

document.getElementById('password').addEventListener('input', function() {
    var passwordInput = document.getElementById('password');
    var submitButton = document.getElementById('submit-button');
    if (passwordInput.value.trim() !== '') {
        submitButton.disabled = false; // Kích hoạt nút submit khi có mật khẩu
    } else {
        submitButton.disabled = true; // Vô hiệu hóa nút submit khi không có mật khẩu
    }
});
