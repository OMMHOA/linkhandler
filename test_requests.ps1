# Powershell

Invoke-WebRequest -Uri "http://localhost:8080/languages" `
-Method "POST" `
-Headers @{
"Cache-Control"="max-age=0"
  "Upgrade-Insecure-Requests"="1"
  "Origin"="http://localhost:8080"
  "User-Agent"="Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/88.0.4324.192 Safari/537.36 OPR/74.0.3911.218"
  "Accept"="text/html,application/xhtml+xml,application/xml;q=0.9,image/avif,image/webp,image/apng,*/*;q=0.8,application/signed-exchange;v=b3;q=0.9"
  "Sec-Fetch-Site"="same-origin"
  "Sec-Fetch-Mode"="navigate"
  "Sec-Fetch-User"="?1"
  "Sec-Fetch-Dest"="document"
  "Referer"="http://localhost:8080/languages"
  "Accept-Encoding"="gzip, deflate, br"
  "Accept-Language"="en-US,en;q=0.9"
} `
-ContentType "application/x-www-form-urlencoded" `
-Body "name=magyar"


Invoke-WebRequest -Uri "http://localhost:8080/teachers" `
-Method "POST" `
-Headers @{
"Cache-Control"="max-age=0"
  "Upgrade-Insecure-Requests"="1"
  "Origin"="http://localhost:8080"
  "User-Agent"="Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/88.0.4324.192 Safari/537.36 OPR/74.0.3911.218"
  "Accept"="text/html,application/xhtml+xml,application/xml;q=0.9,image/avif,image/webp,image/apng,*/*;q=0.8,application/signed-exchange;v=b3;q=0.9"
  "Sec-Fetch-Site"="same-origin"
  "Sec-Fetch-Mode"="navigate"
  "Sec-Fetch-User"="?1"
  "Sec-Fetch-Dest"="document"
  "Referer"="http://localhost:8080/teachers"
  "Accept-Encoding"="gzip, deflate, br"
  "Accept-Language"="en-US,en;q=0.9"
} `
-ContentType "application/x-www-form-urlencoded" `
-Body "name=ommhoa&telNum=11122233344&email=ekiki400%40yahoo.com&languages=magyar"


Invoke-WebRequest -Uri "http://localhost:8080/courses" `
-Method "POST" `
-Headers @{
"Pragma"="no-cache"
  "Cache-Control"="no-cache"
  "Upgrade-Insecure-Requests"="1"
  "Origin"="http://localhost:8080"
  "User-Agent"="Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/88.0.4324.192 Safari/537.36 OPR/74.0.3911.218"
  "Accept"="text/html,application/xhtml+xml,application/xml;q=0.9,image/avif,image/webp,image/apng,*/*;q=0.8,application/signed-exchange;v=b3;q=0.9"
  "Sec-Fetch-Site"="same-origin"
  "Sec-Fetch-Mode"="navigate"
  "Sec-Fetch-User"="?1"
  "Sec-Fetch-Dest"="document"
  "Referer"="http://localhost:8080/courses"
  "Accept-Encoding"="gzip, deflate, br"
  "Accept-Language"="en-US,en;q=0.9"
} `
-ContentType "application/x-www-form-urlencoded" `
-Body "teacher=ommhoa&language=magyar&totalHours=30&startDate=2021-04-06&endDate=2021-04-30&hourlyWage=100&contribution=50&level=B2"
