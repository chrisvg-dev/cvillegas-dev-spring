## Keystore
1. openssl pkcs12 -inkey file.key -in file.cer -export -out intermediate_keys.pkcs12 
2. keytool -importkeystore -alias cvillegas-dev -srckeystore intermediate_keys.pkcs12 -srcstoretype pkcs12 -destkeystore keystore.jks