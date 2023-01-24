import {NextRequest, NextResponse} from 'next/server';

export function middleware(req: NextRequest) {
  // console.log('Success access middleware: Home');
  // console.log('Access token: ' + req.cookies.get('token')?.value);

  return NextResponse.next();
}

export const config = {
  matcher: '/',
}