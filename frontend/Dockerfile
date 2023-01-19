FROM node:16.14.2-alpine

WORKDIR /application
COPY . .

RUN npm install
RUN npm run build

CMD ["npm", "run", "start"]

EXPOSE 3000