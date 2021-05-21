package jp.co.toppan;

import java.nio.charset.StandardCharsets;
import java.util.Base64;

import software.amazon.awssdk.core.ResponseBytes;
import software.amazon.awssdk.regions.Region;
import software.amazon.awssdk.services.s3.S3Client;
import software.amazon.awssdk.services.s3.model.GetObjectRequest;
import software.amazon.awssdk.services.s3.model.GetObjectResponse;

public class Main {

	public static void main(String[] args) {
			System.out.println("hello world!");


			// S3に接続
//			AmazonS3 client = AmazonS3ClientBuilder.standard().withRegion(Regions.AP_NORTHEAST_1).build();

			// S3へアップロード
//			ByteArrayInputStream bis = new ByteArrayInputStream(naiyo.getBytes());
//
//			ObjectMetadata metaData = new ObjectMetadata();
//			metaData.setContentLength(naiyo.getBytes().length);
//
			try {
//				client.putObject("salad-bar-dev-static-files",  "TOPPAN/9999.txt", bis, metaData);


//				CloudFrontClient amazonCloudFront = CloudFrontClient.builder()
//						.region(Region.AWS_GLOBAL)
//						.build();
//
//				Paths paths = Paths.builder()
//						.items("/TOPPAN/18")
//						.quantity(1)
//						.build();
//
//				InvalidationBatch invalidationBatch = InvalidationBatch.builder()
//						.paths(paths)
//						.callerReference(Long.toString(Calendar.getInstance().getTimeInMillis()))
//						.build();
//
//				ListDistributionsResponse res = amazonCloudFront.listDistributions();
//
//				res.distributionList().items().forEach(item -> {
//					System.out.println(item.id());
//					CreateInvalidationRequest request = CreateInvalidationRequest
//					.builder()
//					.distributionId(item.id())
//					.invalidationBatch(invalidationBatch).build();
//
//					amazonCloudFront.createInvalidation(request);
//				});





				String backetName = "salad-bar-dev-static-files";
				String fileName = "18";
				String naiyo = "アクセス設定確認４";



				byte[] a = Base64.getEncoder().encode("ほげほげ".getBytes(StandardCharsets.UTF_8));

				String en1 = new String(a, StandardCharsets.UTF_8);
				System.out.println(en1);

				S3Client s3Client = S3Client.builder().region(Region.AP_NORTHEAST_1).build();

				ResponseBytes<GetObjectResponse> res = s3Client.getObjectAsBytes(GetObjectRequest.builder()
						.bucket(backetName)
						.key("TOPPAN/18")
						.build());

				System.out.println(res.asUtf8String());
				System.out.println(Base64.getEncoder().encode(res.asUtf8String().getBytes(StandardCharsets.UTF_8)));
				System.out.println(new String(Base64.getEncoder().encode(res.asUtf8String().getBytes(StandardCharsets.UTF_8)), StandardCharsets.UTF_8));

				System.out.println(new String(Base64.getEncoder().encode(res.asByteArray()), StandardCharsets.UTF_8));


//				s3Client.putObject(PutObjectRequest.builder()
//		                .bucket(backetName)
//		                .key("TEST/" + fileName)
//		                .acl(ObjectCannedACL.PUBLIC_READ)
//		                .build(),
//		                RequestBody.fromBytes(naiyo.getBytes()));
//
//				String mattaku = s3Client.utilities().getUrl(builder -> builder.bucket(backetName).key("TEST/" + fileName)).toExternalForm();
//
//				System.out.println(mattaku);


			} catch (Exception e) {
				e.printStackTrace();
			}

			System.out.println("end");
		}


}
