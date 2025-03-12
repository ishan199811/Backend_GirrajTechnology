FROM ubuntu:latest

# Install dependencies
RUN apt update && apt install -y curl wget 

# Install Ollama
RUN curl -fsSL https://ollama.com/install.sh | sh

# Expose Ollama API port
EXPOSE 11434

# Start Ollama server
CMD ["ollama", "serve"]
