

# 📪 Alterdata Config. ClienteBD 2.0

Jultamente com o [network-probe](https://github.com/daviddev16/network-probe) que faz com que o servidor responda uma mensagem vinda da estação e [alterdata-cliente-bd-api](https://github.com/daviddev16/alterdata-clientebd-api) que permite editar as propriedades do ClienteBD no regedit, este clienteBD faz **a configuração automática do IP do servidor na estação**, sem precisar se preocupar com mudanças de IP por DHCP, ou problemas no servidor DNS.

<br>
<p align="center">
  <img src="https://i.imgur.com/Gm2gLG0.png" alt="Cliente BD 2.0"/>
</p>
<br>

# 💠 Funcionamento

Através de um broadcast enviado pela estação (client-side), o servidor (server-side) recebe a mensagem e envia um pacote para a estação de volta, assim a estação pode configurar o IP do servidor, sem de fato saber quem é o servidor. 


# ⚠️ Importante

- Esse repositório não é homologado ou tem qualquer vínculo com a Alterdata Software, foi desenvolvido por mim mesmo, apenas para teste. Porfavor, não utilizar para fins de produção.
- Nenhuma "feature" de segurança foi adicionada ainda por ser um **protótipo**.

# ♻️ JRE 

Por questões de acessibildade, desenvolvi esse projeto usando a JRE 1.8_333 da Oracle.
