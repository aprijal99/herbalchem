FROM node:16.14.2-alpine
WORKDIR /app
COPY . .
RUN npm install --prefer-offline --no-audit

EXPOSE 3000

CMD ["npm", "run", "start"]
