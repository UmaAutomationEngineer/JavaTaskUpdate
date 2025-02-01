package epam.tasks.apitasks.task6;

public class JiraPayload {
	public static String bodyToCreateIssue = "{\"fields\": {\n" +
            "        \"summary\": \"New bug 1 from api call!\",\n" +
            "        \"issuetype\": {\n" +
            "            \"id\": \"10008\"\n" +
            "        },\n" +
            "        \"project\": {\n" +
            "            \"key\": \"NSJP\"\n" +
            "        },\n" +
            "        \"description\": {\n" +
            "            \"type\": \"doc\",\n" +
            "            \"version\": 1,\n" +
            "            \"content\": [\n" +
            "                {\n" +
            "                \"type\": \"paragraph\",\n" +
            "                \"content\": [\n" +
            "                    {\n" +
            "                    \"text\": \"This is the description.\",\n" +
            "                    \"type\": \"text\"\n" +
            "                    }\n" +
            "                ]\n" +
            "                }\n" +
            "            ]\n" +
            "        }\n" +
            "    }\n" +
            "}";

	public static String bodyToUpdateIssue = "{\"fields\": {\n" +
            "        \"summary\": \"Updating bug from api call!\",\n" +
            "        \"issuetype\": {\n" +
            "            \"id\": \"10008\"\n" +
            "        },\n" +
            "        \"project\": {\n" +
            "            \"key\": \"NSJP\"\n" +
            "        },\n" +
            "        \"description\": {\n" +
            "            \"type\": \"doc\",\n" +
            "            \"version\": 1,\n" +
            "            \"content\": [\n" +
            "                {\n" +
            "                \"type\": \"paragraph\",\n" +
            "                \"content\": [\n" +
            "                    {\n" +
            "                    \"text\": \"This is the updated description.\",\n" +
            "                    \"type\": \"text\"\n" +
            "                    }\n" +
            "                ]\n" +
            "                }\n" +
            "            ]\n" +
            "        }\n" +
            "    }\n" +
            "}";


}
