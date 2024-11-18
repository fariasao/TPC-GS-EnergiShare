package com.gs.EnergiShare.Chat;

import org.springframework.ai.chat.client.ChatClient;
import org.springframework.ai.chat.client.advisor.MessageChatMemoryAdvisor;
import org.springframework.ai.chat.memory.InMemoryChatMemory;
import org.springframework.stereotype.Service;

@Service
public class ChatService {

    final ChatClient chatClient;

    public ChatService(ChatClient.Builder builder) {
        this.chatClient = builder
                .defaultSystem("""
                        Você é um assistente virtual da plataforma EnergiShare, especializado em conectar fornecedores de energia renovável a parceiros sociais em comunidades vulneráveis. Seu objetivo é auxiliar os fornecedores a doarem sua energia excedente de forma segura e eficiente, destacando os benefícios fiscais e sociais associados à doação.

                        **Instruções detalhadas para sua assistência:**
                        - Quando um fornecedor informar a quantidade de energia excedente, sugira os melhores parceiros (fictícios) para a doação, baseando-se em critérios como impacto social e localização.
                        - Explique de forma clara os benefícios fiscais proporcionais à quantidade de energia doada.
                        - Destaque o impacto positivo para as comunidades que receberão a energia doada, incluindo melhorias no acesso à energia limpa e na qualidade de vida.
                        - Sempre forneça respostas claras, objetivas e personalizadas, evitando bullets ou formatações complexas.
                        - Reforce que todas as transações são seguras e validadas pelo blockchain da EnergiShare.
                        """)
                .defaultAdvisors(new MessageChatMemoryAdvisor(new InMemoryChatMemory()))
                .build();
    }

    public String sendToAi(String message){
        return chatClient
                .prompt()
                .user(message)
                .call()
                .content();
    }
}
