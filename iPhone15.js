document.addEventListener("DOMContentLoaded", function() {
    // Slider handling
    let slider = document.querySelector('.slider .list');
    let items = document.querySelectorAll('.slider .list .item');
    let dots = document.querySelectorAll('.slider .dots li');
    let lengthItems = items.length - 1;
    let active = 0;
    let refreshInterval;
    let isRunning = true; // Track the state of the slider
    let videoElement = null;

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
        // Check if there's a video element in the current slide
        if (videoElement) {
            if (!videoElement.ended) {
                // Wait for the video to end before moving to the next slide
                videoElement.onended = () => {
                    active = (active + 1 <= lengthItems) ? active + 1 : 0;
                    reloadSlider();
                };
                return;
            }
        }

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

    // Update video element reference when the slider changes
    slider.addEventListener('transitionend', () => {
        videoElement = items[active].querySelector('video');
    });
});
