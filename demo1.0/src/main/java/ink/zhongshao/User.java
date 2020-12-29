/**
 * 
 */
package ink.zhongshao;

import java.util.Date;
import javax.annotation.Generated;

/**
 * @author zs
 * @date 2020年12月29日
 */
public class User {

	private String name;

	private Date date;

	@Generated("SparkTools")
	private User(Builder builder) {
		this.name = builder.name;
		this.date = builder.date;
	}

	/**
	 * Creates builder to build {@link User}.
	 * 
	 * @return created builder
	 */
	@Generated("SparkTools")
	public static Builder builder() {
		return new Builder();
	}

	/**
	 * Builder to build {@link User}.
	 */
	@Generated("SparkTools")
	public static final class Builder {
		private String name;
		private Date date;

		private Builder() {
		}

		public Builder withName(String name) {
			this.name = name;
			return this;
		}

		public Builder withDate(Date date) {
			this.date = date;
			return this;
		}

		public User build() {
			return new User(this);
		}
	}

	@Override
	public String toString() {
		return "User [name=" + name + ", date=" + date + "]";
	}

	public static void main(String[] args) {

		User user = User.builder().withName("那么").withDate(new Date()).build();

		System.out.println(user);
		
		
		
		
		
	}

}
