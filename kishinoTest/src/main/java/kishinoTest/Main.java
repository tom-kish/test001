package kishinoTest;

import software.amazon.awssdk.services.cloudfront.CloudFrontClient;
import software.amazon.awssdk.services.cloudfront.model.CreateInvalidationRequest;
import software.amazon.awssdk.services.cloudfront.model.InvalidationBatch;

public class Main {

	public static void main(String[] args) {
		System.out.println("hello world!");

//		// S3に接続
//		AmazonS3 client = AmazonS3ClientBuilder.standard().withRegion(Regions.AP_NORTHEAST_1).build();;
//
//		// S3へアップロード
//		String naiyo = "どうしよう";
//
//		ByteArrayInputStream bis = new ByteArrayInputStream(naiyo.getBytes());
//
//		ObjectMetadata metaData = new ObjectMetadata();
//
		try {
//			client.putObject("salad-bar-dev-static-files",  "TOPPAN/9999.txt", bis, metaData);

//			AWSCredentials awsCredentials = new DefaultAWSCredentialsProviderChain().getCredentials();
			CloudFrontClient client = CloudFrontClient.create();

//			Paths invalidation_paths = new Paths().withItems("/path/to/invalidate/foo.jpg", "/path/file2.txt").withQuantity(2);
//			InvalidationBatch invalidation_batch = new InvalidationBatch(invalidation_paths, "unique_id_like_a_date");
//			CreateInvalidationRequest invalidation = new CreateInvalidationRequest("distributionID", invalidation_batch);
//			CreateInvalidationResult ret = client.createInvalidation(invalidation);


			CloudFrontClient amazonCloudFront = CloudFrontClient.create();
//			AmazonCloudFront amazonCloudFront = AmazonCloudFrontClientBuilder.standard().build();
			software.amazon.awssdk.services.cloudfront.model.Paths paths = software.amazon.awssdk.services.cloudfront.model.Paths.builder()
					.items("/TOPPAN/18")
					.quantity(1)
					.build();
			//		new Paths().withItems("/path/*");

			InvalidationBatch invalidationBatch = InvalidationBatch.builder().paths(paths).build();


			// InvalidationBatch invalidationBatch = new InvalidationBatch(paths, Long.toString(Calendar.getInstance().getTimeInMillis()));
			CreateInvalidationRequest request = CreateInvalidationRequest
					.builder()
					.distributionId("<DISTRIBUTION_ID>").
					invalidationBatch(invalidationBatch).build();

			amazonCloudFront.createInvalidation(request);


		} catch (Exception e) {
			e.printStackTrace();
		}


		System.out.println("end");
	}

}
