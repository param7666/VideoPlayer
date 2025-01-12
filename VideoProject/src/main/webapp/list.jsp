<%@ page contentType="text/html;charset=UTF-8" language="java" import="java.util.*, JavaBean.*, retrive.*" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Video List</title>
    <style>
        body {
            font-family: Arial, sans-serif;
            background-color: #f4f7fc;
            margin: 0;
            padding: 0;
        }

        h1 {
            text-align: center;
            margin-top: 20px;
            color: #333;
        }

        table {
            width: 80%;
            margin: 20px auto;
            border-collapse: collapse;
            background-color: #fff;
            border-radius: 8px;
            box-shadow: 0 4px 8px rgba(0, 0, 0, 0.1);
        }

        th, td {
            padding: 12px 15px;
            text-align: center;
            border: 1px solid #ddd;
        }

        th {
            background-color: #007BFF;
            color: white;
        }

        tr:nth-child(even) {
            background-color: #f9f9f9;
        }

        tr:hover {
            background-color: #f1f1f1;
        }

        a {
            color: #007BFF;
            text-decoration: none;
            font-weight: bold;
        }

        a:hover {
            text-decoration: underline;
        }

        /* Mobile Responsive */
        @media (max-width: 600px) {
            table {
                width: 100%;
            }

            th, td {
                padding: 10px;
            }
        }

    </style>
</head>
<body>

    <h1>Video List</h1>

    <table>
        <thead>
            <tr>
                <th>Video ID</th>
                <th>Video Name</th>
                <th>Video File</th>
            </tr>
        </thead>
        <tbody>
            <% 
                // Retrieve the list of videos from the request
                ArrayList<Video> videoList = (ArrayList<Video>) request.getAttribute("vl");

                // Loop through the video list and display the data
                if (videoList != null && !videoList.isEmpty()) {
                    for (Video video : videoList) {
            %>
            <tr>
                <td><%= video.getId() %></td>
                <td><%= video.getName() %></td>
                <td>
                    <!-- Link to watch the video -->
                    <a href="WatchVideoServlet?id=<%= video.getId() %>">Watch</a>
                </td>
            </tr>
            <% 
                    }
                } else {
            %>
            <tr>
                <td colspan="3">No videos available</td>
            </tr>
            <% 
                }
            %>
        </tbody>
    </table>

</body>
</html>
