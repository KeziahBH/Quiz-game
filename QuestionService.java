import com.sun.net.httpserver.HttpServer;
import com.sun.net.httpserver.HttpHandler;
import com.sun.net.httpserver.HttpExchange;

import java.io.IOException;
import java.io.OutputStream;
import java.net.InetSocketAddress;
import java.nio.charset.StandardCharsets;

public class QuizHttpServer {

    public static void main(String[] args) throws Exception {
        System.out.println("Starting Quiz API server...");

        HttpServer server = HttpServer.create(new InetSocketAddress(8080), 0);
        server.createContext("/questions", new QuestionHandler());
        server.start();

        System.out.println("Server running at: http://localhost:8080/questions");
    }

    static class QuestionHandler implements HttpHandler {
        @Override
        public void handle(HttpExchange exchange) throws IOException {
            if (!exchange.getRequestMethod().equalsIgnoreCase("GET")) {
                exchange.sendResponseHeaders(405, -1);
                return;
            }

            QuestionService service = new QuestionService();
            Question[] questions = service.questions;

            String json = convertToJson(questions);

            exchange.getResponseHeaders().set("Content-Type", "application/json");
            exchange.getResponseHeaders().set("Access-Control-Allow-Origin", "*");

            byte[] response = json.getBytes(StandardCharsets.UTF_8);
            exchange.sendResponseHeaders(200, response.length);

            OutputStream os = exchange.getResponseBody();
            os.write(response);
            os.close();
        }
    }

    private static String convertToJson(Question[] qArr) {
        StringBuilder sb = new StringBuilder();
        sb.append("[");

        for (int i = 0; i < qArr.length; i++) {
            Question q = qArr[i];

            sb.append("{")
              .append("\"id\":").append(q.getId()).append(",")
              .append("\"question\":\"").append(escape(q.getQuestion())).append("\",")
              .append("\"options\":[")
              .append("\"").append(escape(q.getOpt1())).append("\",")
              .append("\"").append(escape(q.getOpt2())).append("\",")
              .append("\"").append(escape(q.getOpt3())).append("\",")
              .append("\"").append(escape(q.getOpt4())).append("\"")
              .append("],")
              .append("\"answer\":\"").append(escape(q.getAnswer())).append("\"")
              .append("}");

            if (i < qArr.length - 1) sb.append(",");
        }
        sb.append("]");

        return sb.toString();
    }

    private static String escape(String s) {
        return s.replace("\"", "\\\"");
    }
}
