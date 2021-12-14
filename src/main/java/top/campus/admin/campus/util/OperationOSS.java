package top.campus.admin.campus.util;

import com.aliyun.oss.OSS;
import com.aliyun.oss.OSSClientBuilder;
import com.aliyun.oss.model.*;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

/**
 * @author Fall
 */
public class OperationOSS {
    /**
     * Endpoint以杭州为例，其它Region请按实际情况填写。
     */
    private String endpoint;
    private String usableEndpoint;
    /**
     * 阿里云主账号AccessKey拥有所有API的访问权限，风险很高。强烈建议您创建并使用RAM账号进行API访问或日常运维，请登录RAM控制台创建RAM账号。
     */
    private String accessKeyId;
    private String accessKeySecret;
    private String bucketName;
    private OSS ossClient = null;

    private OperationOSS() {

    }

    public OperationOSS(String endpoint, String accessKeyId, String accessKeySecret, String bucketName) {
        this.endpoint = endpoint;
        this.accessKeyId = accessKeyId;
        this.accessKeySecret = accessKeySecret;
        this.bucketName = bucketName;
        this.usableEndpoint = "https://" + endpoint + ".aliyuncs.com";
        this.ossClient = new OSSClientBuilder().build(usableEndpoint, accessKeyId, accessKeySecret);
    }

    public void updateToOSSFile(String fileName, String filePath, String suffix, InputStream file) {
        System.out.println("上传开始");
        System.out.println("正在上传 " + fileName + " 文件");
        ossClient.putObject(bucketName, filePath + "/" + fileName + "." + suffix, file);
        System.out.println("上传完成");

        ossClient.shutdown();
    }

    public void updateToOSSFile(String fileName, String filePath, String suffix, String text) {
        System.out.println("上传开始");
        System.out.println("正在上传 " + fileName + " 文件");

        ObjectMetadata objectMetadata = new ObjectMetadata();
        objectMetadata.setContentEncoding("utf-8");

        try {
            ossClient.putObject(bucketName, filePath + "/" + fileName + "." + suffix, new ByteArrayInputStream(text.getBytes("utf-8")), objectMetadata);
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        System.out.println("上传完成");

        ossClient.shutdown();
    }

    public void updateToOssFolder(String path, String filePath, int num) {
        File baseFile = new File(filePath);
        System.out.println("上传开始");

        for (File file : baseFile.listFiles()) {
            if (!file.isDirectory()) {
                //记录文件地址
                String temp = file.toString();
                //String fileName = temp.split("/|\\\\")[temp.split("/|\\\\").length - 1];
                //记录文件后缀名
                String suffix = file.toString().split("\\.")[1];
                //文件中的内容
                byte[] content = null;

                System.out.println("正在上传 " + file + " 文件");
                try {
                    //暂存文件的比特流
                    ArrayList<Byte> byteList = new ArrayList<>();
                    FileInputStream inputStream = new FileInputStream(temp);
                    int tmp;
                    while ((tmp = inputStream.read()) != -1) {
                        byteList.add((byte) tmp);
                    }

                    //将对象Byte转换成基础类型byte
                    content = new byte[byteList.size()];
                    for (int i = 0; i < byteList.size(); i++) {
                        content[i] = byteList.get(i);
                    }
                } catch (FileNotFoundException e) {
                    System.out.print("文件不存在 ");
                    e.printStackTrace();
                } catch (IOException e) {
                    System.out.print("文件读异常 ");
                    e.printStackTrace();
                }

                //通过这个记录上传的个数
                num++;
                ossClient.putObject(bucketName, path + "/" + num + "." + suffix, new ByteArrayInputStream(content));
                System.out.println("上传完成");
            }
        }

        System.out.println("上传完毕");
        ossClient.shutdown();
    }

    public List<String> ListFileByOSS(String prefix, int size) {
        List<String> list = new ArrayList<>();

        // 构造ListObjectsRequest请求。
        ListObjectsRequest listObjectsRequest = new ListObjectsRequest(bucketName);
        // 请求size个这样的文件
        listObjectsRequest.setMaxKeys(size);
        listObjectsRequest.setPrefix(prefix + "/");
        listObjectsRequest.setDelimiter("/");

        // 列举文件。
        ObjectListing listing = ossClient.listObjects(listObjectsRequest);

        // 遍历所有文件。
        System.out.println("Objects:");
        for (OSSObjectSummary objectSummary : listing.getObjectSummaries()) {
            list.add("https://" + bucketName + "." + endpoint + ".aliyuncs.com/" + objectSummary.getKey());
        }

        return list;
    }

    public String readByOSS(String name) {
        String context = "";
        String objectName = name;
        // 创建OSSClient实例。
        OSS ossClient = new OSSClientBuilder().build(endpoint, accessKeyId, accessKeySecret);

        // ossObject包含文件所在的存储空间名称、文件名称、文件元信息以及一个输入流。
        OSSObject ossObject = ossClient.getObject(bucketName, objectName);

        // 读取文件内容。
        System.out.println("Object content:");
        BufferedReader reader = new BufferedReader(new InputStreamReader(ossObject.getObjectContent()));
        while (true) {
            String line = null;
            try {
                line = reader.readLine();
                reader.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
            if (line == null) {
                break;
            }
            context += line;
            System.out.println("\n" + line);
        }
        // 数据读取完成后，获取的流必须关闭，否则会造成连接泄漏，导致请求无连接可用，程序无法正常工作。


        // 关闭OSSClient。
        ossClient.shutdown();

        return context;
    }

    public boolean deleteByOSS(String name) {
        boolean exist = ossClient.doesObjectExist(bucketName, name);
        if (!exist) {
            return false;
        }
        ossClient.deleteObject(bucketName, name);
        ossClient.shutdown();
        return true;
    }
}
