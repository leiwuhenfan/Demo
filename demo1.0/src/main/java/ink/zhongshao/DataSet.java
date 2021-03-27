/**
 * 
 */
package ink.zhongshao;

import javax.annotation.Generated;

/**
 * @author zs
 * @date 2021年1月28日
 */
public class DataSet {

	
	private Long id;
	
	private String name;
	
	private Long formId;

	@Generated("SparkTools")
	private DataSet(Builder builder) {
		this.id = builder.id;
		this.name = builder.name;
		this.formId = builder.formId;
	}

	/**
	 * Creates builder to build {@link DataSet}.
	 * @return created builder
	 */
	@Generated("SparkTools")
	public static IIdStage builder() {
		return new Builder();
	}

	@Generated("SparkTools")
	public interface IIdStage {
		public INameStage withId(Long id);
	}

	@Generated("SparkTools")
	public interface INameStage {
		public IFormIdStage withName(String name);
	}

	@Generated("SparkTools")
	public interface IFormIdStage {
		public IBuildStage withFormId(Long formId);
	}

	@Generated("SparkTools")
	public interface IBuildStage {
		public DataSet build();
	}

	/**
	 * Builder to build {@link DataSet}.
	 */
	@Generated("SparkTools")
	public static final class Builder implements IIdStage, INameStage, IFormIdStage, IBuildStage {
		private Long id;
		private String name;
		private Long formId;

		private Builder() {
		}

		@Override
		public INameStage withId(Long id) {
			this.id = id;
			return this;
		}

		@Override
		public IFormIdStage withName(String name) {
			this.name = name;
			return this;
		}

		@Override
		public IBuildStage withFormId(Long formId) {
			this.formId = formId;
			return this;
		}

		@Override
		public DataSet build() {
			return new DataSet(this);
		}
	}
	
	public static void main(String[] args) {
		DataSet.builder().withId(9L).withName("").withFormId(9L);
	}
}
