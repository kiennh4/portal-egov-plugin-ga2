$(document).on("ready", function() {
	var parrentBlock = $(".vbpq_search_results");
	var listDownload = parrentBlock.find(".taglib-search-iterator").find("td.col-download");
	listDownload.each(function(){
		var aTag = $(this).find("a");
		aTag.empty();
		aTag.html('<i class="fa fa-download" aria-hidden="true"></i>');
		aTag.attr("target","_blank");
	});
});