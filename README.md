## Making a keystore
1. openssl pkcs12 -inkey file.key -in file.cer -export -out intermediate_keys.pkcs12 
2. keytool -importkeystore -srckeystore intermediate_keys.pkcs12 -srcstoretype pkcs12 -destkeystore keystore.jks

## Next
When you have your key, you need moving it into src/main/resources