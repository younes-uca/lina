## 1- Consult download
got to the link :   https://developer.hashicorp.com/consul/install?product_intent=consul
and download exec file in Win section

## 2- Install the exec file
unzip the file and lunch the exec file

## 3- Lunch consul
lunch the command (in the same dir where you have the exec file) ::
consul agent -server -bootstrap-expect=1 -data-dir=data -ui -bind=your-ip-exemple:192.168.1.141
(to get your ip >> ipconfig in win or ip for linux)



