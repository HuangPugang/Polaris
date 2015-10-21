package com.hpg.demo.bean;

/**
 * 只带imageName的PostImage类
 * @author pau
 *
 */
public class PostImageName {
	public String image_name;

	public String getImage_name() {
			return image_name;
		}
		public void setImage_name(String image_name) {
			this.image_name = image_name;
		}
		public PostImageName(String image_name) {
			super();
			this.image_name = image_name;
		}
		public PostImageName(){}


}
