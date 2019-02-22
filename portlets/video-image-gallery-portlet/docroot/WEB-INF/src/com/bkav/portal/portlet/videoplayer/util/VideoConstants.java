package com.bkav.portal.portlet.videoplayer.util;

public class VideoConstants {

	public static final int DEFAULT_VIDEO_FRAME_WIDTH = 340;
	
	public static final int DEFAULT_VIDEO_FRAME_HEIGHT = 200;
	
	public static final long DEFAULT_VIDEO_MAX_SIZE = 20;
	
	public static final long DEFAULT_IMAGE_THUMBNAIL_MAX_SIZE = 5;
	
	//He so chuyen doi giua byte va Mega bytes
	public static final long FILE_SIZE_COEFFICENT = 1048576; //== 2^10 * 2^10 == 1024 * 1024
	
	public static final String INTERNAL_VIDEO_TYPE="internal";
	
	public static final String EXTERNAL_VIDEO_TYPE="external";
	
	public static final String[] DEFAULT_VIDEO_EXTENSIONS = {".flv",".mp4"};
	
	public static final String[] DEFAULT_IMAGE_THUMBNAIL_EXTENSIONS = {".gif",".jpeg",".jpg",".png"};
	
}
