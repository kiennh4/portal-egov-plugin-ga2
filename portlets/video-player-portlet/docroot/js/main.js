$(document).on("click", ".viewVideo", function() {
	var videoTitle = $(this).find("span").text();
	var mediaUrl = $(this).attr("mediaUrl");
	var topVideo = $("#topVideo");
	var videoType = $(this).attr("data-type");
	var videoFrame = $("#videoFrame");
	var oldPlayer = document.getElementById('player');
	var playerBlock = $(".video-player");
	if(oldPlayer != null){
		videojs(oldPlayer).dispose();
	}
	playerBlock.empty();
	if(videoType === "external"){
		if(playerBlock.find("#videoFrame").length){
			videoFrame.attr("src", mediaUrl);
		} else{
			playerBlock.append('<iframe style="height:100% !important" id="videoFrame" src="' + mediaUrl + '" allowfullscreen> </iframe>')
		}
	}else{
		playerBlock.append('<video id="player" class="video-js vjs-default-skin" autoplay controls preload="none" loop width="640" height="360"></video>');
		var player = videojs('player', {
	        plugins: {
	            videoJsResolutionSwitcher: {
	                dynamicLabel:  true
	            }
	        }
	    });
	    player.updateSrc([
	       	{
				src: mediaUrl,
				type: 'video/mp4',
				res: 360,
				label: '360p'
			},
	        {
	            src: mediaUrl,
	            type: 'video/mp4',
	            res: 480,
	            label: '480p'
	        },
	        {
	            src: mediaUrl,
	            type: 'video/mp4',
	            res: 720,
	            label: '720p'
	        },
	        {
	            src: mediaUrl,
	            type: 'video/mp4',
	            res: 1080,
	            label: '1080p'
	        }
	    ])
	}
	topVideo.text(videoTitle);
});
