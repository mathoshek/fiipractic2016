# fiipractic2016

## How to configure tomcat to work on ssl
1. Create a keystore file to store the server's private key and self-signed certificate by executing the following command:
        "%JAVA_HOME%\bin\keytool" -genkey -alias tomcat -keyalg RSA
    and specify a password value of "changeit".

2. Uncomment the "SSL HTTP/1.1 Connector" entry in $CATALINA_BASE/conf/server.xml.

## How to make Postman work with ssl
1. Go in Chrome to any link (for example https://localhost:8443/rest/users)
2. Accept the certificate
3. Click on the lock icon on the top left in the URL bar.
4. Open the Connection tab in the dropdown that comes up
5. Click on certificate information
6. In the certificates window, go to the Details tab
7. Select Copy to File
8. Save the certificate file on your disk. Close the certificate window.
9. Go to Chrome > Settings, search for SSL (chrome://settings/search#ssl) and click on Manage certificates
10. Go to the "Trusted Root Certification Authorities" tab and click on import
11. Select the file you saved on your disk in step 8.
12. Finish the import.