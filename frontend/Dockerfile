FROM node:16.14.2-alpine AS BASE
RUN apk add --no-cache libc6-compat
WORKDIR /app
COPY package.json package-lock.json ./
RUN npm ci

FROM node:16.14.2-alpine AS BUILD
WORKDIR /app
COPY --from=BASE /app/node_modules ./node_modules
COPY . .
RUN npm run build

FROM node:16.14.2-alpine AS PRODUCTION
WORKDIR /app
COPY --from=BUILD /app/public ./public
COPY --from=BUILD /app/.next/standalone ./
COPY --from=BUILD /app/.next/static ./.next/static
COPY --from=BUILD /app/.env.local ./

EXPOSE 3000

CMD ["node", "server.js"]
