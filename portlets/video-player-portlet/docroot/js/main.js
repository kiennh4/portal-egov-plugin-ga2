$(document).on("click", ".viewVideo", function() {
	var videoTitle = $(this).attr("title");
	var mediaUrl = $(this).attr("mediaUrl");
	var topVideo = $("#topVideo");
	var videoFrame = $("#videoFrame");
	videoFrame.attr("src", mediaUrl);
	topVideo.text(videoTitle);
});