// Mã JavaScript cho video
const video = document.getElementById('video');
const playPauseBtn = document.getElementById('playPauseBtn');

function togglePlayPause() {
    if (video.paused) {
        video.play();
        playPauseBtn.innerHTML = 'Tạm dừng <i class="ri-pause-circle-line"></i>';
    } else {
        video.pause();
        playPauseBtn.innerHTML = 'Phát lại <i class="ri-play-circle-line"></i>';
    }
}

video.addEventListener('ended', () => {
    playPauseBtn.innerHTML = 'Phát lại <i class="ri-play-circle-line"></i>';
});


