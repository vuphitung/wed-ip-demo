document.addEventListener("DOMContentLoaded", function() {
    // Xử lý cho myVideo (Video không phát liên tục)
    var myVideo = document.getElementById('myVideo');
    var textContainer = document.getElementById('textContainer');
    var buttonContainer = document.getElementById('buttonContainer');
    var pauseBtn = document.getElementById('pauseBtn');

    myVideo.addEventListener('timeupdate', function() {
        var currentTime = myVideo.currentTime;
        var duration = myVideo.duration;
        var fadeInTime = duration - 3; 

        if (currentTime >= fadeInTime) {
            textContainer.classList.add('visible');
            buttonContainer.classList.add('visible');
        }
    });

    // Xử lý cho video2 (Video phát liên tục)
    var video2 = document.querySelector('.video2');
    if (video2) {
        video2.loop = true; // Đảm bảo video phát liên tục
        video2.play(); // Bắt đầu phát video
    }

    // Slider handling
    let slider = document.querySelector('.slider .list');
    let items = document.querySelectorAll('.slider .list .item');
    let dots = document.querySelectorAll('.slider .dots li');
    let lengthItems = items.length - 1;
    let active = 0;
    let refreshInterval;
    let isRunning = true; // Track the state of the slider

    function reloadSlider() {
        slider.style.left = -items[active].offsetLeft + 'px';

        let last_active_dot = document.querySelector('.slider .dots li.active');
        if (last_active_dot) {
            last_active_dot.classList.remove('active');
        }
        dots[active].classList.add('active');
    }

    function startSlider() {
        clearInterval(refreshInterval);
        refreshInterval = setInterval(() => { nextImage() }, 3000);
        pauseBtn.innerHTML = '<i class="ri-play-fill"></i>'; // Biểu tượng khi slider đang chạy
        isRunning = true;
    }

    function stopSlider() {
        clearInterval(refreshInterval);
        pauseBtn.innerHTML = '<i class="ri-pause-fill"></i>'; // Biểu tượng khi slider bị dừng
        isRunning = false;
    }

    function nextImage() {
        active = (active + 1 <= lengthItems) ? active + 1 : 0;
        reloadSlider();
    }

    // Bắt đầu slider khi trang tải
    startSlider();

    dots.forEach((li, key) => {
        li.addEventListener('click', () => {
            active = key;
            reloadSlider();
        });
    });

    pauseBtn.addEventListener('click', () => {
        if (isRunning) {
            stopSlider();
        } else {
            startSlider();
        }
    });

    window.onresize = function(event) {
        reloadSlider();
    };

    var fadeOutText = document.querySelector('.fade-out-text');
    
    // Đặt trạng thái ban đầu của phần tử
    fadeOutText.classList.remove('hidden');

    // Hiển thị chữ trong 3 giây và sau đó bắt đầu biến mất
    setTimeout(function() {
        fadeOutText.classList.add('hidden');
    }, 2700); // Sau 3 giây, chữ bắt đầu biến mất
});
